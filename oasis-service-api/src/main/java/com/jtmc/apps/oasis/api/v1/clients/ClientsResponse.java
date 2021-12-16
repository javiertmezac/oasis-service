package com.jtmc.apps.oasis.api.v1.clients;

import java.util.Date;

public class ClientsResponse extends ClientBase {

    private Boolean clientStatus;
    private Date clientRegistration;
    private double clientPrice;
    private Date clientNextClean;
    private String nextCleaningComments;

    public String getNextCleaningComments() {
        return nextCleaningComments;
    }

    public void setNextCleaningComments(String nextCleaningComments) {
        this.nextCleaningComments = nextCleaningComments;
    }

    public Boolean getClientStatus() {
        return clientStatus;
    }

    public void setClientStatus(Boolean clientStatus) {
        this.clientStatus = clientStatus;
    }

    public Date getClientRegistration() {
        return clientRegistration;
    }

    public void setClientRegistration(Date clientRegistration) {
        this.clientRegistration = clientRegistration;
    }

    public Date getClientNextClean() {
        return clientNextClean;
    }

    public void setClientNextClean(Date clientNextClean) {
        this.clientNextClean = clientNextClean;
    }

    public double getClientPrice() {
        return clientPrice;
    }

    public void setClientPrice(double clientPrice) {
        this.clientPrice = clientPrice;
    }

}
