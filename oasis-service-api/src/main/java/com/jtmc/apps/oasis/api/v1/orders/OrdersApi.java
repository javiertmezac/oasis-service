package com.jtmc.apps.oasis.api.v1.orders;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/v1/orders")
public interface OrdersApi {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    OrdersResponseList getOrders();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    OrdersResponse getOrder(@PathParam("id") int orderId);

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response createOrder(OrderRequest orderRequest);

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Response deleteMarkerOrder(@PathParam("id") int orderId);
}
