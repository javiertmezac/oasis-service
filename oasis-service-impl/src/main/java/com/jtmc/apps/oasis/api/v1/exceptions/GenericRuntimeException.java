package com.jtmc.apps.oasis.api.v1.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class GenericRuntimeException implements ExceptionMapper<RuntimeException> {

    @Override
    public Response toResponse(RuntimeException e) {

        e.printStackTrace();
        if (e instanceof IllegalArgumentException) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        ResponseErrorMessage errorMessage = new ResponseErrorMessage();
        errorMessage.setType(e.getClass().getSimpleName());
        errorMessage.setMessage(e.getMessage());
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorMessage).build();
    }

    private static class ResponseErrorMessage {
        private String message;
        private String type;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
