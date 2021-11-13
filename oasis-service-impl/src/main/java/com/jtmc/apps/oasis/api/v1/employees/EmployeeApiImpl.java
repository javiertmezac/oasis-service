package com.jtmc.apps.oasis.api.v1.employees;

import com.google.inject.Inject;
import com.jtmc.apps.oasis.api.v1.clients.ClientsResponse;
import com.jtmc.apps.oasis.api.v1.clients.ClientsResponseList;
import com.jtmc.apps.oasis.application.employees.EmployeesAppImpl;
import com.jtmc.apps.oasis.domain.CustomEmployee;
import com.jtmc.apps.oasis.domain.Trabajador;
import org.glassfish.jersey.internal.inject.Custom;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeApiImpl implements  EmployeeApi {

    @Inject
    private EmployeesAppImpl employeesApp;

    @Inject
    private EmployeeResponseConverter employeeResponseConverter;

    @Inject
    private CustomEmployeeResponseConverter customEmployeeResponseConverter;

    @Override
    public EmployeeResponse getEmployee(int employeeId) {
        Optional<Trabajador> employee = employeesApp.selectOne(employeeId);
        if (!employee.isPresent()) {
            throw new WebApplicationException("Trabajador not found",
                    Response.Status.NOT_FOUND);
        }

        return employeeResponseConverter.apply(employee.get());
    }

    @Override
    public EmployeeResponseList getEmployees(boolean listBlockNumber) {
        List<CustomEmployee> employees = employeesApp.selectAllRecords(listBlockNumber);

        if(employees == null || employees.size() == 0) {
            throw new WebApplicationException("Could not fetch Lista Trabajadores", Response.Status.NOT_FOUND);
        }

        Stream<EmployeeResponse> employeeResponseStream = employees
                .stream().map(e -> customEmployeeResponseConverter.apply(e)
                );

        EmployeeResponseList responseList = new EmployeeResponseList();
        responseList.setEmployeeList(employeeResponseStream.collect(Collectors.toList()));
        return responseList;
    }
}
