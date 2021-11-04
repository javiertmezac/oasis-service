package com.jtmc.apps.oasis.api.v1.notes;

import java.util.Date;

public class NotesResponse extends NotesBaseResponse {
    private String clientName;
    private String employeeName;
    private double debt;

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public double getDebt() {
        return debt;
    }

    public void setDebt(double debt) {
        this.debt = debt;
    }
}
