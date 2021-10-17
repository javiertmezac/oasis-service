package com.jtmc.apps.oasis.api.v1.healthcheck;

import com.jtmc.apps.oasis.api.v1.annotations.JWTRequired;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

@Path("/public/v1")
public interface HealthcheckApi {

    @GET
    @Path("/status")
    Response getStatus();

    @GET
    @JWTRequired
    @Path("/try-auth")
    Response tryAuth();

}
