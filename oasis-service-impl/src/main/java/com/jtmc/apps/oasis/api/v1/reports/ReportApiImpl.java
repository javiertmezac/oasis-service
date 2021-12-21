package com.jtmc.apps.oasis.api.v1.reports;

import com.google.inject.Inject;
import com.jtmc.apps.oasis.api.v1.clients.ClientsResponse;
import com.jtmc.apps.oasis.api.v1.clients.CustomClientsResponseConverter;
import com.jtmc.apps.oasis.application.clients.ClientAppImpl;
import com.jtmc.apps.oasis.domain.CustomClient;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReportApiImpl implements ReportApi {

    @Inject
    private ClientAppImpl clientApp;

    @Inject
    private CustomClientsResponseConverter customClientsResponseConverter;

    @Override
    public ReportNotRecentOrderResponse fetchClientsNotRecentOrder() {
        List<CustomClient> clients = clientApp.selectClientsNotRecentOrders();

        Stream<ClientsResponse> clientsResponseStream =
                clients.stream().map(c -> customClientsResponseConverter.apply(c));

        ReportNotRecentOrderResponse response = new ReportNotRecentOrderResponse();
        response.setTotalClients(clientApp.countActiveClients());
        response.setClients(clientsResponseStream.collect(Collectors.toList()));
        response.setTotalClientsNotRecentOrders(response.getClients().size());
        return response;
    }
}
