package com.jtmc.apps.oasis.api.v1.clients;

import java.util.List;

public class ClientsResponseList {

    private List<ClientsResponse> clientsResponses;

    public List<ClientsResponse> getClientsResponses() {
        return clientsResponses;
    }

    public void setClientsResponses(List<ClientsResponse> clientsResponses) {
        this.clientsResponses = clientsResponses;
    }
}
