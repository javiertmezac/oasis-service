package com.jtmc.apps.oasis.api.v1.employees;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    Response createEmployee(EmployeeRequest employeeRequest);

    @PUT
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    Response updateEmployee(EmployeeRequest employeeRequest);

    @DELETE
    @Path("/{id}")
    Response deleteMarkerEmployee(@PathParam("id") int employeeId);

    @POST
    @Path("/{employeeId}/blocks/{blockId}")
    Response incrementNextBlockNumber(@PathParam("employeeId") int employeeId,
                                      @PathParam("blockId") int blockId,
                                      @QueryParam("currentBlockNumber") int currentBlockNumber,
                                      @FormParam("description") String description);
}

