package com.jtmc.apps.oasis.application.clients;

import com.google.inject.Inject;
import com.jtmc.apps.oasis.domain.CustomClient;
import com.jtmc.apps.oasis.domain.Empresa;
import com.jtmc.apps.oasis.infrastructure.CustomClientMapper;
import com.jtmc.apps.oasis.infrastructure.EmpresaDynamicSqlSupport;
import com.jtmc.apps.oasis.infrastructure.EmpresaMapper;
import com.jtmc.apps.oasis.infrastructure.PreciogranelDynamicSqlSupport;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.glassfish.jersey.internal.inject.Custom;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ClientAppImpl {

    @Inject
    private SqlSessionFactory sqlSessionFactory;

    public List<CustomClient> selectAllRows() {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            CustomClientMapper mapper = session.getMapper(CustomClientMapper.class);
            SelectStatementProvider statementProvider = MyBatis3Utils
                    .select(addBasicColumns(), EmpresaDynamicSqlSupport.empresa,
                            c -> c.join(PreciogranelDynamicSqlSupport.preciogranel)
                                    .on(EmpresaDynamicSqlSupport.idprecio, SqlBuilder.equalTo(PreciogranelDynamicSqlSupport.id))
                                    .where(EmpresaDynamicSqlSupport.status, SqlBuilder.isTrue())
                    );
            return mapper.selectManyCustomClient(statementProvider);
        }
    }

    public Optional<CustomClient> selectOne(int clientId) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            CustomClientMapper mapper = session.getMapper(CustomClientMapper.class);

            SelectStatementProvider statementProvider = MyBatis3Utils
                    .select(addBasicColumns(), EmpresaDynamicSqlSupport.empresa,
                            c -> c.join(PreciogranelDynamicSqlSupport.preciogranel)
                                    .on(EmpresaDynamicSqlSupport.idprecio, SqlBuilder.equalTo(PreciogranelDynamicSqlSupport.id))
                                    .where(EmpresaDynamicSqlSupport.status, SqlBuilder.isTrue())
                                    .and(EmpresaDynamicSqlSupport.id, SqlBuilder.isEqualTo(clientId))
                    );
            return mapper.selectOneCustomClient(statementProvider);
        }
    }

    private BasicColumn[] addBasicColumns() {
        ArrayList<BasicColumn> list = new ArrayList<>(Arrays.asList(EmpresaMapper.selectList));
        list.add(PreciogranelDynamicSqlSupport.precio.as("price"));

        return BasicColumn.columnList(list.toArray(new BasicColumn[0]));
    }

    public int insertClient(Empresa client) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            EmpresaMapper mapper = session.getMapper(EmpresaMapper.class);
            client.setStatus(true);
            return mapper.insertSelective(client);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }
}
