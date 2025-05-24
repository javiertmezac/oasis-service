package com.jtmc.apps.oasis.api.v2.clients;

import com.jtmc.apps.oasis.api.v1.clients.ClientsResponseList;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/v2/clients")
public interface ClientsApi {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    PaginatedClientsResponse getClients(@QueryParam("page") int page, @QueryParam("size") int size,
                                        @QueryParam("search") String search, @QueryParam("sortBy") String sortBy,
                                        @QueryParam("sortOrder") String sortOrder);
}
