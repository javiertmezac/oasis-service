package com.jtmc.apps.oasis.api.v1.healthcheck;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/public/v1")
public interface HealthcheckApi {

    @GET
    @Path("/status")
    Response getStatus();

}
