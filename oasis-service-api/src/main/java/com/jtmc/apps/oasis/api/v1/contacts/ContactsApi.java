package com.jtmc.apps.oasis.api.v1.contacts;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    Response createContact(ContactRequest contactRequest);

    @PUT
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    Response updateContact(ContactRequest contactRequest);

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Response deleteMarkerContact(@PathParam("id") int contactId);
}
