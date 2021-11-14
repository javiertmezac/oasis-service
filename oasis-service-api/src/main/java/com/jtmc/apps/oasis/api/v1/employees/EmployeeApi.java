package com.jtmc.apps.oasis.api.v1.employees;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/v1/employees")
public interface EmployeeApi {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    EmployeeResponse getEmployee(@PathParam("id") int employeeId);

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    EmployeeResponseList getEmployees(@QueryParam("listBlockNumber") @DefaultValue("false") boolean listBlockNumber);
}
