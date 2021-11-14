package com.jtmc.apps.oasis.api.v1.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class GenericRuntimeException implements ExceptionMapper<RuntimeException> {

    @Override
    public Response toResponse(RuntimeException e) {

        e.printStackTrace();

        ResponseErrorMessage errorMessage = new ResponseErrorMessage();
        errorMessage.setType(e.getClass().getSimpleName());
        errorMessage.setMessage(e.getMessage());

        if (e instanceof IllegalArgumentException) {
            return Response.status(Response.Status.BAD_REQUEST).entity(errorMessage).build();
        }

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorMessage).build();
    }

}
