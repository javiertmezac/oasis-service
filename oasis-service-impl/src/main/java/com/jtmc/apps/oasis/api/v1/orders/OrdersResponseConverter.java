package com.jtmc.apps.oasis.api.v1.orders;

import com.jtmc.apps.oasis.domain.CustomOrder;
import com.jtmc.apps.oasis.domain.Pedido;
import com.jtmc.apps.oasis.infrastructure.CustomOrderMapper;

import java.util.function.Function;

public class OrdersResponseConverter implements Function<CustomOrder, OrdersResponse> {

    @Override
    public OrdersResponse apply(CustomOrder p) {
        OrdersResponse response = new OrdersResponse();
        response.setOrderId(p.getId());
        response.setClientId(p.getIdempresa());
        response.setEmployeeId(p.getIdchofer());
        response.setComments(p.getObservaciones());
        response.setNotification(p.getIdnotificacion());
        response.setPriority(p.getIdprioridad());
        response.setDeliveryDate(p.getFechaentregar());
        response.setRegistrationDate(p.getFecharegistro());
        response.setClientName(p.getClientName());
        response.setEmployeeName(p.getEmployeeName());

        response.setNotificationDescr(setOrderStatusDescription(p.getIdnotificacion()));
        response.setPriorityDescr(setOrderStatusDescription(p.getIdprioridad()));
        return response;
    }

    private String setOrderStatusDescription(int notification) {
        switch (notification) {
            case 1:
                return "Alta";
            case 2:
                return "Media";
            case 3:
                return "Baja";
            case 4:
                return "Creada";
            case 5:
                return "Atendiendo";
            case 6:
                return "Terminada";
            case 7:
                return "Crédito";
            default:
                return "n/a";
        }
    }
}
