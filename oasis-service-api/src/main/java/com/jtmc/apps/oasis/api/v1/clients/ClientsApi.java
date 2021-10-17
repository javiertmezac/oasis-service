package com.jtmc.apps.oasis.api.v1.clients;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/v1/clients")
public interface ClientsApi {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    ClientsResponseList getClients();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    ClientsResponse getClient(@PathParam("id") int clientId);
}
