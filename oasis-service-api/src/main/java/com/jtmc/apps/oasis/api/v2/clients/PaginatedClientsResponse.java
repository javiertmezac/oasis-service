package com.jtmc.apps.oasis.api.v2.clients;

import com.jtmc.apps.oasis.api.v1.clients.ClientsResponse;
import com.jtmc.apps.oasis.api.v2.Pagination;

import java.util.List;

public class PaginatedClientsResponse {
    private List<ClientsResponse> clients;
    private Pagination pagination;

    public List<ClientsResponse> getClients() {
        return clients;
    }

    public void setClients(List<ClientsResponse> clients) {
        this.clients = clients;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }
}
