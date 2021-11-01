package com.jtmc.apps.oasis.api.v1.orders;

import com.google.inject.Inject;
import com.jtmc.apps.oasis.application.clients.ClientAppImpl;
import com.jtmc.apps.oasis.application.employees.EmployeesAppImpl;
import com.jtmc.apps.oasis.application.orders.OrdersAppImpl;
import com.jtmc.apps.oasis.domain.CustomOrder;
import com.jtmc.apps.oasis.domain.Empresa;
import com.jtmc.apps.oasis.domain.Pedido;
import com.jtmc.apps.oasis.domain.Trabajador;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class OrdersApiImpl implements OrdersApi {

    final static int HIGH_PRIORITY = 1;
    final static int NOTIFICATION_CREATED = 4;

    @Inject
    private OrdersAppImpl ordersApp;

    @Inject
    private ClientAppImpl clientApp;

    @Inject
    private EmployeesAppImpl employeesApp;

    @Inject
    private OrdersConverter ordersConverter;

    @Inject
    private OrdersResponseConverter ordersResponseConverter;

    @Override
    public OrdersResponseList getOrders() {
        List<CustomOrder> ordersList = ordersApp.selectNotTerminatedRecords();

        if (ordersList == null || ordersList.size() == 0) {
            throw new WebApplicationException("Could not fetch Orders",
                    Response.Status.NOT_FOUND);
        }

        Stream<OrdersResponse> ordersResponseStream =
                ordersList.stream().map(o -> ordersResponseConverter.apply(o));

        OrdersResponseList responseList = new OrdersResponseList();
        responseList.setOrdersList(ordersResponseStream.collect(Collectors.toList()));
        return responseList;
    }

    @Override
    public OrdersResponse getOrder(int orderId) {
        Optional<CustomOrder> order = ordersApp.selectOne(orderId);
        if (!order.isPresent()) {
            throw new WebApplicationException("Order not Found",
                    Response.Status.NOT_FOUND);
        }
        return ordersResponseConverter.apply(order.get());
    }

    @Override
    public Response createOrder(OrderRequest orderRequest) {
        checkNotNull(orderRequest, "OrderRequest object is null");

        int newOrder = 0;
        checkArgument(orderRequest.getOrderId() != null && orderRequest.getOrderId() == newOrder,
                "Invalid OrderId");
        checkArgument(orderRequest.getEmployeeId() > 0,"Invalid EmployeeId");
        checkArgument(orderRequest.getClientId() > 0,"Invalid ClientId");
        checkNotNull(orderRequest.getRegistrationDate(), "Provide a registrationDate");
        checkNotNull(orderRequest.getDeliveryDate(), "Provide a deliveryDate");

        Optional<Empresa> client = clientApp.selectOne(orderRequest.getClientId());
        if(!client.isPresent()) {
            throw new WebApplicationException("Client not Found", Response.Status.NOT_FOUND);
        }

        Optional<Trabajador> employee = employeesApp.selectOne(orderRequest.getEmployeeId());
        if(!employee.isPresent()) {
            throw new WebApplicationException("Employee not Found", Response.Status.NOT_FOUND);
        }

        orderRequest.setOrderId(null);
        if (orderRequest.getNotification() == 0) {
            orderRequest.setNotification(NOTIFICATION_CREATED);
        }
        if(orderRequest.getPriority() == 0) {
            orderRequest.setPriority(HIGH_PRIORITY);
        }

        int value = ordersApp.createOrder(ordersConverter.apply(orderRequest));
        int validState = 1;
        if (value != validState) {
            throw new WebApplicationException("Order record not inserted", Response.Status.INTERNAL_SERVER_ERROR);
        }
        System.out.println("Order Inserted Successfully");
        return Response.ok().build();
    }

    @Override
    public Response deleteMarkerOrder(int orderId) {
        checkArgument(orderId > 0, "Invalid orderId");

        Pedido updateOrder = new Pedido();
        updateOrder.setId(orderId);
        updateOrder.setStatus(false);

        int value = ordersApp.deleteMark(updateOrder);
        if(value != 1) {
            System.out.printf("Attempted to delete orderId %d but it failed.$n", orderId);
           throw new WebApplicationException("Order was not deleted successfully", Response.Status.INTERNAL_SERVER_ERROR);
        }

        System.out.printf("Order %d was delete marked successfully.%n", orderId);
        return Response.ok().build();
    }

    /* todo: review update functionality
    once the order has been assigned a note with an employee, the employee cannot be
    modified, but order can be "canceled/removed"
     */

}
