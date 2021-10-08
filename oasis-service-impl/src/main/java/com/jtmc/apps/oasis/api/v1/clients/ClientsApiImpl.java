package com.jtmc.apps.oasis.api.v1.clients;

import com.google.inject.Inject;
import com.jtmc.apps.oasis.application.clients.ClientAppImpl;

public class ClientsApiImpl implements ClientsApi {

    @Inject
    private ClientAppImpl clientApp;

    @Override
    public ClientsResponseList getClients() {
        ClientsResponseList responseList = new ClientsResponseList();
        responseList.setClientsResponses(clientApp.selectAllRows());
        return responseList;
    }

    @Override
    public ClientsResponse getClient(int clientId) {
        return clientApp.selectOne(clientId);
    }
}
