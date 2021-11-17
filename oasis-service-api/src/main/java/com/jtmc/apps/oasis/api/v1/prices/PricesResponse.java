package com.jtmc.apps.oasis.api.v1.prices;

public class PricesResponse {

    private int priceId;
    private double price;

    public int getPriceId() {
        return priceId;
    }

    public void setPriceId(int priceId) {
        this.priceId = priceId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
