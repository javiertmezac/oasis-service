package com.jtmc.apps.oasis.api.v1.contacts;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/v1/contacts")
public interface ContactsApi {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    ContactsResponseList getContacts();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    ContactsResponse getContact(@PathParam("id") int contactId);
}
