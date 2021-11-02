package com.jtmc.apps.oasis.api.v1.notes;

import com.jtmc.apps.oasis.domain.CustomNote;

import java.util.function.Function;

public class NotesResponseConverter implements Function<CustomNote, NotesResponse> {

    @Override
    public NotesResponse apply(CustomNote customNote) {
        NotesResponse notesResponse = new NotesResponse();
        notesResponse.setClientName(customNote.getClientName());
        notesResponse.setEmployeeName(customNote.getEmployeeName());
        notesResponse.setNote(customNote.getNonota());
        notesResponse.setTotal(customNote.getTotal().doubleValue());
        notesResponse.setDebt(customNote.getDebt());

        return notesResponse;
    }
}
