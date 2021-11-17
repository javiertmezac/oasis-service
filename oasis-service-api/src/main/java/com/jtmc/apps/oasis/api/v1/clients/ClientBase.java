package com.jtmc.apps.oasis.api.v1.clients;

public class ClientBase {
    private Integer clientId;
    private String clientCode;
    private String clientInvoice;
    private String clientName;
    private String clientRfc;
    private String clientTel;
    private String clientNeighborhood;
    private String clientStreet;
    private String clientNoInt;
    private String clientNoOut;
    private String clientCp;
    private Byte clientPriceId;

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

    public Byte getClientPriceId() {
        return clientPriceId;
    }

    public void setClientPriceId(Byte clientPriceId) {
        this.clientPriceId = clientPriceId;
    }

    public String getClientNoInt() {
        return clientNoInt;
    }

    public void setClientNoInt(String clientNoInt) {
        this.clientNoInt = clientNoInt;
    }

    public String getClientNoOut() {
        return clientNoOut;
    }

    public void setClientNoOut(String clientNoOut) {
        this.clientNoOut = clientNoOut;
    }

    public String getClientCp() {
        return clientCp;
    }

    public void setClientCp(String clientCp) {
        this.clientCp = clientCp;
    }
}
