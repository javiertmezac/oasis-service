package com.jtmc.apps.oasis.api.v1.reports;

import com.jtmc.apps.oasis.api.v1.clients.ClientsResponse;

import java.util.List;

public class ReportNotRecentOrderResponse {

    private long totalClients;
    private int totalClientsNotRecentOrders;
    private List<ClientsResponse> clients;

    public long getTotalClients() {
        return totalClients;
    }

    public void setTotalClients(long totalClients) {
        this.totalClients = totalClients;
    }

    public int getTotalClientsNotRecentOrders() {
        return totalClientsNotRecentOrders;
    }

    public void setTotalClientsNotRecentOrders(int totalClientsNotRecentOrders) {
        this.totalClientsNotRecentOrders = totalClientsNotRecentOrders;
    }

    public List<ClientsResponse> getClients() {
        return clients;
    }

    public void setClients(List<ClientsResponse> clients) {
        this.clients = clients;
    }
}
