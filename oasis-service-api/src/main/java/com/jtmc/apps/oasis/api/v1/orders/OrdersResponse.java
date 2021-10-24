package com.jtmc.apps.oasis.api.v1.orders;

public class OrdersResponse extends OrdersBase {
    private String clientName;
    private String employeeName;
    private String notificationDescr;
    private String priorityDescr;

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
