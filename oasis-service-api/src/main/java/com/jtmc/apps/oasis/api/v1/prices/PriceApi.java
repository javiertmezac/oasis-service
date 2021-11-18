package com.jtmc.apps.oasis.api.v1.prices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/v1/prices")
public interface PriceApi {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    PricesResponseList getPrices();
}
