package com.jtmc.apps.oasis.api.v1.prices;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/v1/prices")
public interface PriceApi {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    PricesResponseList getPrices();

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    Response insertPrice(PriceRequest priceRequest);
}
