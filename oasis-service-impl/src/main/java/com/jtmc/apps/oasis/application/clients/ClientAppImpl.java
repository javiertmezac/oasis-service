package com.jtmc.apps.oasis.application.clients;

import com.google.inject.Inject;
import com.jtmc.apps.oasis.api.v1.clients.ClientsResponse;
import com.jtmc.apps.oasis.domain.Empresa;
import com.jtmc.apps.oasis.infrastructure.EmpresaMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClientAppImpl {

    @Inject
    private SqlSessionFactory sqlSessionFactory;

    public List<Empresa> selectAllRows() {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            EmpresaMapper mapper = session.getMapper(EmpresaMapper.class);
            return mapper.select(SelectDSLCompleter.allRows());


        }
    }

    public Optional<Empresa> selectOne(int clientId) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            EmpresaMapper mapper = session.getMapper(EmpresaMapper.class);
            return mapper.selectByPrimaryKey(clientId);
        }
    }
}
