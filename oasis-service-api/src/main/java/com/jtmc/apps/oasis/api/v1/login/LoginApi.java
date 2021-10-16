package com.jtmc.apps.oasis.api.v1.login;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/login")
public interface LoginApi {

    @Path("/")
    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    LoginResponse login();
}
