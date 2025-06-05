package com.jtmc.apps.oasis.api.v2.clients;

import com.google.inject.Inject;
import com.jtmc.apps.oasis.api.v1.annotations.JWTRequired;
import com.jtmc.apps.oasis.api.v1.clients.ClientsResponse;
import com.jtmc.apps.oasis.api.v1.clients.CustomClientsResponseConverter;
import com.jtmc.apps.oasis.api.v2.Pageable;
import com.jtmc.apps.oasis.api.v2.Pagination;
import com.jtmc.apps.oasis.application.clients.ClientAppImpl;
import com.jtmc.apps.oasis.domain.CustomClient;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@JWTRequired
public class ClientsApiImpl implements ClientsApi {

    @Inject
    private ClientAppImpl repository;

    @Inject
    private CustomClientsResponseConverter customClientsResponseConverter;

    @Override
    public PaginatedClientsResponse getClients(int page, int size, String search, String sortBy, String sortOrder) {
        Pageable pageable = new Pageable(page, size, sortOrder, sortBy);
        List<CustomClient> all = repository.findAll(pageable, search);

        Stream<ClientsResponse> clientsResponseStream = all
                .stream().map(c -> customClientsResponseConverter.apply(c));

        long totalItems = repository.countActiveClients(search);
        int totalPages = repository.totalPages(totalItems, size);

        PaginatedClientsResponse r = new PaginatedClientsResponse();
        r.setPagination(new Pagination(page, size,  totalPages, totalItems));
        r.setClients(clientsResponseStream.collect(Collectors.toList()));
        return r;
    }

}
