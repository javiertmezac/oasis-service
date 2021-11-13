package com.jtmc.apps.oasis.api.v1.clients;

import com.google.inject.Inject;
import com.jtmc.apps.oasis.api.v1.annotations.JWTRequired;
import com.jtmc.apps.oasis.application.clients.ClientAppImpl;
import com.jtmc.apps.oasis.domain.CustomClient;
import com.jtmc.apps.oasis.domain.Empresa;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@JWTRequired
public class ClientsApiImpl implements ClientsApi {

    @Inject
    private ClientAppImpl clientApp;

    @Inject
    private ClientsResponseConverter clientsResponseConverter;

    @Inject
    private CustomClientsResponseConverter customClientsResponseConverter;

    @Override
    public ClientsResponseList getClients() {

        List<Empresa> empresaList = clientApp.selectAllRows();
        if(empresaList == null || empresaList.size() == 0) {
            throw new WebApplicationException("Could not fetch EmpresaList", Response.Status.NOT_FOUND);
        }

        Stream<ClientsResponse> clientsResponseStream = empresaList
                    .stream().map(c -> clientsResponseConverter.apply(c)
        );

        ClientsResponseList responseList = new ClientsResponseList();
        responseList.setClientsResponses(clientsResponseStream.collect(Collectors.toList()));
        return responseList;
    }

    @Override
    public ClientsResponse getClient(int clientId) {
         Optional<CustomClient> empresa = clientApp.selectOne(clientId);

        if (!empresa.isPresent()){
            throw new WebApplicationException("Empresa not Found", Response.Status.NOT_FOUND);
        }

        return customClientsResponseConverter.apply(empresa.get());
    }
}
