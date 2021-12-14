package com.jtmc.apps.oasis.api.v1.blocks;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/v1/blocks")
public interface BlockApi {

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    Response createBlock(BlockRequest blockRequest);

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    BlockResponse getBlock(@PathParam("id") int blockId);

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Response deleteMarkBlock(@PathParam("id") int blockId);

    @PUT
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    Response updateBlock(BlockRequest blockRequest);

}
