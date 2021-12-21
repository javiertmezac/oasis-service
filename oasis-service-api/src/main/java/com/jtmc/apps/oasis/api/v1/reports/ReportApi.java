package com.jtmc.apps.oasis.api.v1.reports;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/reports")
public interface ReportApi {

    @GET
    @Path("/clients/not-recent-order")
    @Produces(MediaType.APPLICATION_JSON)
    ReportNotRecentOrderResponse fetchClientsNotRecentOrder();
}
