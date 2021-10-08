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

    public List<ClientsResponse> selectAllRows() {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            EmpresaMapper mapper = session.getMapper(EmpresaMapper.class);

            Stream<ClientsResponse> clientsResponseStream = mapper.select(SelectDSLCompleter.allRows())
                    .stream().map(c -> {
                        ClientsResponse mappingClient = new ClientsResponse();
                        mappingClient.setClientId(c.getId());
                        mappingClient.setClientName(c.getNombre());
                        mappingClient.setClientAddress(
                                String.format("%s, %s", c.getColonia(), c.getCalle())
                        );
                        return mappingClient;
                    }
            );
            return clientsResponseStream.collect(Collectors.toList());
        }
    }

    public ClientsResponse selectOne(int clientId) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            EmpresaMapper mapper = session.getMapper(EmpresaMapper.class);
            Optional<Empresa> empresa = mapper.selectByPrimaryKey(clientId);
            if (!empresa.isPresent()){
                throw new WebApplicationException("Empresa not Found", Response.Status.NOT_FOUND);
            }

            ClientsResponse response = new ClientsResponse();
            response.setClientId(empresa.get().getId());
            response.setClientName(empresa.get().getNombre());
            response.setClientAddress(
                    String.format("%s, %s", empresa.get().getColonia(), empresa.get().getCalle())
            );
            return response;
        }
    }
}
