package com.jtmc.apps.oasis.api.v1.orders;

import java.util.List;

public class OrdersResponseList {
    private List<OrdersResponse> ordersList;

    public List<OrdersResponse> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<OrdersResponse> ordersList) {
        this.ordersList = ordersList;
    }
}
