package com.jtmc.apps.oasis.api.v1.prices;

import com.google.inject.Inject;
import com.jtmc.apps.oasis.application.prices.PriceAppImpl;
import com.jtmc.apps.oasis.domain.Preciogranel;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PriceApiImpl implements PriceApi {

    @Inject
    private PriceAppImpl priceApp;

    @Override
    public PricesResponseList getPrices() {
        List<Preciogranel> prices = priceApp.selectAllRecords();

        PricesResponseList responseList = new PricesResponseList();
        Stream<PricesResponse> pricesResponseStream = prices.stream().map(p -> {
            PricesResponse pricesResponse = new PricesResponse();
            pricesResponse.setPriceId(p.getId());
            pricesResponse.setPrice(p.getPrecio());
            return pricesResponse;
        });

        responseList.setPricesResponseList(pricesResponseStream.collect(Collectors.toList()));
        return responseList;
    }
}
