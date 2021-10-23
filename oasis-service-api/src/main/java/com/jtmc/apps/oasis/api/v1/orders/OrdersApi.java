package com.jtmc.apps.oasis.api.v1.orders;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/v1/orders")
public interface OrdersApi {

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    Response createOrder(OrderRequest orderRequest);
}
