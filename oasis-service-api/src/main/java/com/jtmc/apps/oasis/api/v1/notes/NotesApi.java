package com.jtmc.apps.oasis.api.v1.notes;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/v1/notes")
public interface NotesApi {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    NotesResponseList getNotes();
}
