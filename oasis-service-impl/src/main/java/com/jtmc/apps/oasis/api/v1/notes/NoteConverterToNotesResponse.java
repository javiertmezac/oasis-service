package com.jtmc.apps.oasis.api.v1.notes;

import com.jtmc.apps.oasis.domain.Nota;

import java.util.Date;
import java.util.function.Function;

public class NoteConverterToNotesResponse implements Function<Nota, NotesResponse> {

    @Override
    public NotesResponse apply(Nota nota) {
        NotesResponse response = new NotesResponse();
        response.setNoteId(nota.getId());
        response.setNote(nota.getNonota());
        response.setCredit(nota.getCreditocontado());
        response.setLiters(nota.getLitros());
        response.setRegistration(new Date(nota.getFecharegistro().toEpochMilli()));
        response.setArrival(nota.getLlegada());
        response.setDeparture(nota.getSalida());
        response.setDiscount(nota.getLitrosdescontados());
        response.setDiscountDescription(nota.getRazondescuento());
        response.setEmployeeId(nota.getIdchofer());
        response.setFinalData(nota.getLecturafinal());
        response.setInitialData(nota.getLecturainicial());
        response.setLoad(nota.getDescarga());
        response.setOrderId(nota.getIdpedido());
        response.setTotal(nota.getTotal());
        response.setPrice(nota.getPrecio());
        response.setStatus(nota.getStatus());
        return response;
    }
}
