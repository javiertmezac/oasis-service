package com.jtmc.apps.oasis.application.abonos;

import com.google.inject.Inject;
import com.jtmc.apps.oasis.domain.Abono;
import com.jtmc.apps.oasis.domain.CustomPayment;
import com.jtmc.apps.oasis.infrastructure.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

import java.util.ArrayList;
import java.util.Arrays;
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

    public Optional<Abono> selectNotePaymentStatus(int idNote) {
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

    public int insertPayment(Abono payment) {
        try(SqlSession session = sqlSessionFactory.openSession(true)) {
            AbonoMapper mapper = session.getMapper(AbonoMapper.class);
            payment.setStatus(true);
            return mapper.insertSelective(payment);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    public List<CustomPayment> selectPaymentsFromNote(int noteId) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            CustomPaymentMapper mapper = session.getMapper(CustomPaymentMapper.class);

            ArrayList<BasicColumn> list = new ArrayList<>(Arrays.asList(AbonoMapper.selectList));
            list.add(TrabajadorDynamicSqlSupport.nombre.as("employeeName"));

            SelectStatementProvider statementProvider = MyBatis3Utils.select(BasicColumn.columnList(list.toArray(new BasicColumn[0])),
                    AbonoDynamicSqlSupport.abono, c -> c.join(TrabajadorDynamicSqlSupport.trabajador)
                            .on(TrabajadorDynamicSqlSupport.id, SqlBuilder.equalTo(AbonoDynamicSqlSupport.idchofer))
                            .where(AbonoDynamicSqlSupport.idnota, SqlBuilder.isEqualTo(noteId))
                    .and(AbonoDynamicSqlSupport.status, SqlBuilder.isTrue()));

            return mapper.selectManyCustomPayments(statementProvider);
        }
    }
}
