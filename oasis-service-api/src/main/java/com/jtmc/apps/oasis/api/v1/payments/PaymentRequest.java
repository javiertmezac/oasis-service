package com.jtmc.apps.oasis.api.v1.payments;

import java.time.Instant;

public class PaymentRequest {

    private int paymentId;
    private int noteId;
    private Double total;
    private Instant registration;
    private int employeeId;

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Instant getRegistration() {
        return registration;
    }

    public void setRegistration(Instant registration) {
        this.registration = registration;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}
