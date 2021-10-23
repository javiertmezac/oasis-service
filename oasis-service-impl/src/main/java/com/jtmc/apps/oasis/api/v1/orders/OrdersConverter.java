package com.jtmc.apps.oasis.api.v1.orders;

import com.jtmc.apps.oasis.domain.Pedido;

import java.util.function.Function;

public class OrdersConverter implements Function<OrderRequest, Pedido> {

    @Override
    public Pedido apply(OrderRequest orderRequest) {
        Pedido p = new Pedido();
        p.setId(orderRequest.getOrderId());
        p.setIdempresa(orderRequest.getClientId());
        p.setIdchofer(orderRequest.getEmployeeId());
        p.setFecharegistro(orderRequest.getRegistrationDate());
        p.setFechaentregar(orderRequest.getDeliveryDate());
        p.setObservaciones(orderRequest.getComments() == null ? "" : orderRequest.getComments());
        p.setIdnotificacion(orderRequest.getNotification());
        p.setIdprioridad(orderRequest.getPriority());
        return p;
    }
}
