package com.jtmc.apps.oasis.api.v1.notes;

import com.jtmc.apps.oasis.domain.CustomNote;

import java.util.Date;
import java.util.function.Function;

public class NotesResponseConverter implements Function<CustomNote, NotesResponse> {

    @Override
    public NotesResponse apply(CustomNote customNote) {
        NotesResponse notesResponse = new NotesResponse();
        notesResponse.setNoteId(customNote.getId());
        notesResponse.setNote(customNote.getNonota());
        notesResponse.setOrderId(customNote.getIdpedido());
        notesResponse.setClientName(customNote.getClientName());
        notesResponse.setEmployeeName(customNote.getEmployeeName());
        notesResponse.setRegistration(new Date(customNote.getFecharegistro().toEpochMilli()));
        notesResponse.setLiters(customNote.getLitros());
        notesResponse.setCredit(customNote.getCreditocontado());
        notesResponse.setTotal(customNote.getTotal());
        notesResponse.setDebt(customNote.getDebt());
        return notesResponse;
    }
}
