package com.jtmc.apps.oasis.api.v2.notes;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/v2/notes")
public interface NotesApi {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    PaginatedNotesResponse getNotes(@QueryParam("selectPaidNotes") boolean selectPaidNotes,
                                    @QueryParam("page") int page,
                                    @QueryParam("size") int size,
                                    @QueryParam("search") String search);
}