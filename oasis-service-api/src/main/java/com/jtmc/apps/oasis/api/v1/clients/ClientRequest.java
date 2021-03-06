package com.jtmc.apps.oasis.api.v1.clients;

import java.time.Instant;

public class ClientRequest extends ClientBase {

    private Instant clientInstantRegistration;
    private Instant clientInstantNextClean;
    private String nextCleaningComments;

    public String getNextCleaningComments() {
        return nextCleaningComments;
    }

    public void setNextCleaningComments(String nextCleaningComments) {
        this.nextCleaningComments = nextCleaningComments;
    }

    public Instant getClientInstantRegistration() {
        return clientInstantRegistration;
    }

    public void setClientInstantRegistration(Instant clientInstantRegistration) {
        this.clientInstantRegistration = clientInstantRegistration;
    }

    public Instant getClientInstantNextClean() {
        return clientInstantNextClean;
    }

    public void setClientInstantNextClean(Instant clientInstantNextClean) {
        this.clientInstantNextClean = clientInstantNextClean;
    }
}
