package com.jtmc.apps.oasis.api.v1.clients;

import com.google.inject.Inject;
import com.jtmc.apps.oasis.application.clients.ClientAppImpl;
import com.jtmc.apps.oasis.domain.Empresa;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClientsApiImpl implements ClientsApi {

    @Inject
    private ClientAppImpl clientApp;

    @Inject
    private ClientsResponseConverter clientsResponseConverter;

    @Override
    public ClientsResponseList getClients() {

        List<Empresa> empresaList = clientApp.selectAllRows();
        Stream<ClientsResponse> clientsResponseStream = empresaList
                    .stream().map(c -> clientsResponseConverter.apply(c)
        );

        if(empresaList == null || empresaList.size() == 0) {
            throw new WebApplicationException("Could not fetch EmpresaList", Response.Status.NOT_FOUND);
        }

        ClientsResponseList responseList = new ClientsResponseList();
        responseList.setClientsResponses(clientsResponseStream.collect(Collectors.toList()));
        return responseList;
    }

    @Override
    public ClientsResponse getClient(int clientId) {
         Optional<Empresa> empresa = clientApp.selectOne(clientId);

        if (!empresa.isPresent()){
            throw new WebApplicationException("Empresa not Found", Response.Status.NOT_FOUND);
        }

        return clientsResponseConverter.apply(empresa.get());
    }
}
