package com.jtmc.apps.oasis.api.v1.orders;

import java.util.Date;

public class OrdersResponse extends OrdersBase {
    private String clientName;
    private String employeeName;
    private String notificationDescr;
    private String priorityDescr;

    private Date delivery;
    private Date registration;

    public Date getDelivery() {
        return delivery;
    }

    public void setDelivery(Date delivery) {
        this.delivery = delivery;
    }

    public Date getRegistration() {
        return registration;
    }

    public void setRegistration(Date registration) {
        this.registration = registration;
    }

    public String getPriorityDescr() {
        return priorityDescr;
    }

    public void setPriorityDescr(String priorityDescr) {
        this.priorityDescr = priorityDescr;
    }

    public String getNotificationDescr() {
        return notificationDescr;
    }

    public void setNotificationDescr(String notificationDescr) {
        this.notificationDescr = notificationDescr;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
}
