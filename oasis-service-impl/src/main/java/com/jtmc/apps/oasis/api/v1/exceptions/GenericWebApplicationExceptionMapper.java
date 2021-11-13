package com.jtmc.apps.oasis.api.v1.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class GenericWebApplicationExceptionMapper implements ExceptionMapper<WebApplicationException> {

    @Override
    public Response toResponse(WebApplicationException e) {
        ResponseErrorMessage errorMessage = new ResponseErrorMessage();
        errorMessage.setMessage(e.getMessage());
        errorMessage.setType(e.getClass().getSimpleName());
        return Response.status(e.getResponse().getStatus()).entity(errorMessage).build();
    }
}
