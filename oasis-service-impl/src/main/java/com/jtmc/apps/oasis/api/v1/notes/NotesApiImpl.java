package com.jtmc.apps.oasis.api.v1.notes;

import com.google.inject.Inject;
import com.jtmc.apps.oasis.application.notes.NotesAppImpl;
import com.jtmc.apps.oasis.domain.CustomNote;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NotesApiImpl implements NotesApi {

    @Inject
    private NotesAppImpl notesApp;

    @Inject
    private NotesResponseConverter notesResponseConverter;

    @Override
    public NotesResponseList getNotes() {
        List<CustomNote> noteList = notesApp.selectAllNonPaidNotes();

        if(noteList == null || noteList.size() == 0) {
            throw new WebApplicationException("Could not fetch Notes",
                    Response.Status.NOT_FOUND);
        }

        Stream<NotesResponse> noteResponseStream =
                noteList.stream().map(n -> notesResponseConverter.apply(n));

        NotesResponseList response = new NotesResponseList();
        response.setNotesResponse(noteResponseStream.collect(Collectors.toList()));
        return response;
    }
}
