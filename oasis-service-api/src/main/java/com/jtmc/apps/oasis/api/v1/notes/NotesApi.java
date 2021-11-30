package com.jtmc.apps.oasis.api.v1.notes;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/v1/notes")
public interface NotesApi {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    NotesResponseList getNotes();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    NotesResponse getNote(@PathParam("id") int noteId);

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    Response createNote(NotesRequest notesRequest);

    @PUT
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    Response updateNote(NotesRequest notesRequest);

    @GET
    @Path("/{noteId}/payments")
    @Produces(MediaType.APPLICATION_JSON)
    NotePaymentResponseList fetchPaymentsFromNote(@PathParam("noteId") int noteId);
}
