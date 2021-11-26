package com.jtmc.apps.oasis.api.v1.notes;

import com.jtmc.apps.oasis.api.v1.payments.PaymentResponse;

import java.util.List;

public class NotePaymentResponseList {
    private List<PaymentResponse> notePayments;

    public List<PaymentResponse> getNotePayments() {
        return notePayments;
    }

    public void setNotePayments(List<PaymentResponse> notePayments) {
        this.notePayments = notePayments;
    }
}
