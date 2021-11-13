package com.jtmc.apps.oasis.api.v1.clients;

import java.util.Date;

public class ClientsResponse {

    private Integer clientId;
    private String clientCode;
    private String clientInvoice;
    private String clientName;
    private String clientRfc;
    private String clientTel;
    private String clientNeighborhood;
    private String clientStreet;
    private Integer clientNoInt;
    private Integer clientNoOut;
    private Integer clientCp;
    private Boolean clientStatus;
    private Date clientRegistration;
    private double clientPrice;
    private Byte clientPriceId;
    private Date clientNextClean;

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

    public String getClientInvoice() {
        return clientInvoice;
    }

    public void setClientInvoice(String clientInvoice) {
        this.clientInvoice = clientInvoice;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientRfc() {
        return clientRfc;
    }

    public void setClientRfc(String clientRfc) {
        this.clientRfc = clientRfc;
    }

    public String getClientTel() {
        return clientTel;
    }

    public void setClientTel(String clientTel) {
        this.clientTel = clientTel;
    }

    public String getClientNeighborhood() {
        return clientNeighborhood;
    }

    public void setClientNeighborhood(String clientNeighborhood) {
        this.clientNeighborhood = clientNeighborhood;
    }

    public String getClientStreet() {
        return clientStreet;
    }

    public void setClientStreet(String clientStreet) {
        this.clientStreet = clientStreet;
    }

    public Integer getClientNoInt() {
        return clientNoInt;
    }

    public void setClientNoInt(Integer clientNoInt) {
        this.clientNoInt = clientNoInt;
    }

    public Integer getClientNoOut() {
        return clientNoOut;
    }

    public void setClientNoOut(Integer clientNoOut) {
        this.clientNoOut = clientNoOut;
    }

    public Integer getClientCp() {
        return clientCp;
    }

    public void setClientCp(Integer clientCp) {
        this.clientCp = clientCp;
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

    public Byte getClientPriceId() {
        return clientPriceId;
    }

    public void setClientPriceId(Byte clientPriceId) {
        this.clientPriceId = clientPriceId;
    }
}
