package com.jtmc.apps.oasis.application.clients;

import com.google.inject.Inject;
import com.jtmc.apps.oasis.domain.Empresa;
import com.jtmc.apps.oasis.infrastructure.EmpresaDynamicSqlSupport;
import com.jtmc.apps.oasis.infrastructure.EmpresaMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;

import java.util.List;
import java.util.Optional;

public class ClientAppImpl {

    @Inject
    private SqlSessionFactory sqlSessionFactory;

    public List<Empresa> selectAllRows() {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            EmpresaMapper mapper = session.getMapper(EmpresaMapper.class);
            return mapper.select(c -> c.where(EmpresaDynamicSqlSupport.status, SqlBuilder.isTrue()));
        }
    }

    public Optional<Empresa> selectOne(int clientId) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            EmpresaMapper mapper = session.getMapper(EmpresaMapper.class);
            return mapper.selectByPrimaryKey(clientId);
        }
    }
}
