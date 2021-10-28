package com.jtmc.apps.oasis.api.v1.employees;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
    EmployeeResponseList getEmployees();
}
