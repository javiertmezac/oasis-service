package com.jtmc.apps.oasis.api.v1.prices;

import com.google.inject.Inject;
import com.jtmc.apps.oasis.application.clients.ClientAppImpl;
import com.jtmc.apps.oasis.application.prices.PriceAppImpl;
import com.jtmc.apps.oasis.domain.Empresa;
import com.jtmc.apps.oasis.domain.Preciogranel;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class PriceApiImpl implements PriceApi {

    @Inject
    private PriceAppImpl priceApp;

    @Inject
    private ClientAppImpl clientApp;

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

    @Override
    public Response insertPrice(PriceRequest priceRequest) {
        checkNotNull(priceRequest);
        int newPrice = 0;
        checkArgument(priceRequest.getPriceId() == newPrice, "Invalid priceId");

        Preciogranel price = new Preciogranel();
        price.setId(null);
        price.setPrecio(priceRequest.getPrice());
        if(priceApp.insertPrice(price) != 1) {
            System.out.println("Could not insert new price.");
            throw new WebApplicationException("Not able to insert new price", Response.Status.INTERNAL_SERVER_ERROR);
        }
        System.out.println("New price inserted successfully");
        return Response.ok().build();
    }

    @Override
    public Response deletePrice(int priceId) {
        checkArgument(priceId > 0, "Invalid priceId");

        List<Empresa> clientList = clientApp.selectAllRecordsWithPriceId((byte)priceId);
        if(clientList != null && clientList.size() > 0) {
            System.out.println("Not able to delete price as it is link to Client(s)");
            throw new WebApplicationException("Not able to delete price, it is linked to Client(s)",
                    Response.Status.CONFLICT);
        }

        if(priceApp.deletePrice((byte) priceId) != 1) {
            System.out.println("Not able to delete price");
            throw new WebApplicationException("Could not delete price", Response.Status.INTERNAL_SERVER_ERROR);
        }
        System.out.println("Price successfully deleted");
        return Response.ok().build();
    }
}
