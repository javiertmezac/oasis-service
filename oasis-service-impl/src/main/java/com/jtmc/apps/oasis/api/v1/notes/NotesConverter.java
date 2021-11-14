package com.jtmc.apps.oasis.api.v1.notes;

import com.jtmc.apps.oasis.domain.Nota;

import java.util.function.Function;

public class NotesConverter implements Function<NotesRequest, Nota> {

    @Override
    public Nota apply(NotesRequest notesRequest) {
        Nota n = new Nota();
        n.setId(notesRequest.getNoteId());
        n.setFecharegistro(notesRequest.getRegistrationDate());
        n.setIdchofer(notesRequest.getEmployeeId());
        n.setIdpedido(notesRequest.getOrderId());
        n.setCreditocontado(notesRequest.getCredit());
        n.setDescarga(notesRequest.getLoad());
        n.setLlegada(notesRequest.getArrival());
        n.setSalida(notesRequest.getDeparture());
        n.setLitrosdescontados(notesRequest.getDiscount());
        n.setRazondescuento(notesRequest.getDiscountDescription());
        n.setLitros(notesRequest.getLiters());
        n.setLecturainicial(notesRequest.getInitialData());
        n.setLecturafinal(notesRequest.getFinalData());
        n.setPrecio(notesRequest.getPrice());
        n.setTotal(notesRequest.getTotal());
        n.setNonota(notesRequest.getNote());
        return n;
    }
}
