package com.jtmc.apps.oasis.application.abonos;

import com.google.inject.Inject;
import com.jtmc.apps.oasis.domain.Abono;
import com.jtmc.apps.oasis.infrastructure.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

import java.util.List;
import java.util.Optional;

public class AbonoAppImpl {

    @Inject
    private SqlSessionFactory sqlSessionFactory;


    //todo: lets use this to list Payments with parameters (idNote)
    public List<Abono> selectPaymentSumGroupByNote() {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            AbonoMapper mapper = session.getMapper(AbonoMapper.class);

            BasicColumn[] basicColumn = BasicColumn.columnList(AbonoDynamicSqlSupport.idnota, SqlBuilder.sum(AbonoDynamicSqlSupport.cantidad).as("cantidad"));
            SelectStatementProvider statementProvider = MyBatis3Utils
                    .select(basicColumn, AbonoDynamicSqlSupport.abono,
                            c -> c.where(NotaDynamicSqlSupport.status, SqlBuilder.isTrue())
                                    .groupBy(AbonoDynamicSqlSupport.idnota)
                    );

             return mapper.selectMany(statementProvider);
        }
    }

    public Optional<Abono> selectPaymentStatus(int idNote) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            AbonoMapper mapper = session.getMapper(AbonoMapper.class);

            BasicColumn[] basicColumn = BasicColumn.columnList(AbonoDynamicSqlSupport.idnota,
                    SqlBuilder.sum(AbonoDynamicSqlSupport.cantidad).as("cantidad"));

            SelectStatementProvider statementProvider = MyBatis3Utils
                    .select(basicColumn, AbonoDynamicSqlSupport.abono,
                            c -> c.where(AbonoDynamicSqlSupport.status, SqlBuilder.isTrue())
                                    .and(AbonoDynamicSqlSupport.idnota, SqlBuilder.isEqualTo(idNote))
                                    .groupBy(AbonoDynamicSqlSupport.idnota)
                    );

            return mapper.selectOne(statementProvider);
        }
    }
}
