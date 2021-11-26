package com.jtmc.apps.oasis.api.v1.payments;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/v1/payments")
public interface PaymentApi {

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    Response insertPayment(PaymentRequest paymentRequest);
}
