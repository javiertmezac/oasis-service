package com.jtmc.apps.oasis.api.v1.healthcheck;

import com.google.inject.Inject;

import javax.inject.Named;
import javax.ws.rs.core.Response;

public class HealthcheckApiImpl implements HealthcheckApi {

    @Override
    public Response getStatus() {
        return Response.ok().entity("all chido compa!").build();
    }
}
