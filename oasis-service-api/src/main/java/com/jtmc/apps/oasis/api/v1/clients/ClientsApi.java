package com.jtmc.apps.oasis.api.v1.clients;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    Response insertClient(ClientRequest clientRequest);

    @PUT
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    Response updateClient(ClientRequest clientRequest);

    @DELETE
    @Path("/{id}")
    Response deleteMarkClient(@PathParam("id") int clientId);
}
