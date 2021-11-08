package com.jtmc.apps.oasis.api.v1.notes;

import com.google.inject.Inject;
import com.jtmc.apps.oasis.application.abonos.AbonoAppImpl;
import com.jtmc.apps.oasis.application.notes.NotesAppImpl;
import com.jtmc.apps.oasis.domain.Abono;
import com.jtmc.apps.oasis.domain.CustomNote;
import com.jtmc.apps.oasis.domain.Nota;
import org.apache.commons.lang3.NotImplementedException;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NotesApiImpl implements NotesApi {

    @Inject
    private NotesAppImpl notesApp;

    @Inject
    private AbonoAppImpl abonoApp;

    @Inject
    private NotesResponseConverter notesResponseConverter;

    @Inject
    private NoteConverterToNotesResponse converterToNotesResponse;

    @Override
    public NotesResponseList getNotes() {
        List<CustomNote> noteList = notesApp.selectAllRecords();

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

    @Override
    public NotesResponse getNote(int noteId) {
        Optional<Nota> note = notesApp.selectOneNote(noteId);

        if(!note.isPresent()) {
            throw new WebApplicationException("Note not found", Response.Status.NOT_FOUND);
        }
        NotesResponse notesBaseResponse = converterToNotesResponse.apply(note.get());

        Optional<Abono> paymentStatus = abonoApp.selectPaymentStatus(noteId);
        if (!paymentStatus.isPresent()) {
            notesBaseResponse.setPaid(false);
        } else {
            boolean paid = (notesBaseResponse.getTotal() - paymentStatus.get().getCantidad()) == 0;
            notesBaseResponse.setPaid(paid);
        }
        return notesBaseResponse;
    }

    @Override
    public Response createNote(NotesRequest notesRequest) {
        throw new NotImplementedException("not finished");
    }
}
