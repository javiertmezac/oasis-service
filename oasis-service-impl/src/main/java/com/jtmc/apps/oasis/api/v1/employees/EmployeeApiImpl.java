package com.jtmc.apps.oasis.api.v1.employees;

import com.google.inject.Inject;
import com.jtmc.apps.oasis.application.blockerror.BlockErrorAppImpl;
import com.jtmc.apps.oasis.application.blocks.BlockAppImpl;
import com.jtmc.apps.oasis.application.employees.EmployeesAppImpl;
import com.jtmc.apps.oasis.domain.Bloque;
import com.jtmc.apps.oasis.domain.CustomEmployee;
import com.jtmc.apps.oasis.domain.Serieerror;
import com.jtmc.apps.oasis.domain.Trabajador;
import org.apache.commons.lang3.StringUtils;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class EmployeeApiImpl implements  EmployeeApi {

    @Inject
    private EmployeesAppImpl employeesApp;

    @Inject
    private BlockAppImpl blockApp;

    @Inject
    private BlockErrorAppImpl blockErrorApp;

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
    public EmployeeResponseList getEmployees() {
        List<CustomEmployee> employees = employeesApp.selectAllRecords();

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

    @Override
    public Response createEmployee(EmployeeRequest employeeRequest) {
        checkNotNull(employeeRequest, "EmployeeRequest not valid");
        int newEmployee = 0;
        checkArgument(employeeRequest.getEmployeeId() == newEmployee, "Invalid EmployeeId");
        checkArgument(StringUtils.isNotBlank(employeeRequest.getEmployeeName()), "Invalid EmployeeName");

        Trabajador e = new Trabajador();
        e.setId(null);
        e.setNombre(employeeRequest.getEmployeeName());
        e.setFecharegistro(new Date(Instant.now().toEpochMilli()));
        //todo: ask if this code is relevant or not?
        e.setCodigo(employeeRequest.getEmployeeName().substring(0,2).trim().toUpperCase());
        e.setDireccion(employeeRequest.getAddress());
        e.setTelefono(employeeRequest.getTel());
        int result = employeesApp.insertEmployee(e);
        if(result != 1) {
            throw new WebApplicationException("New Employee not inserted", Response.Status.INTERNAL_SERVER_ERROR);
        }

        System.out.println("New Employee record inserted successfully");
        return Response.ok().build();
    }

    @Override
    public Response updateEmployee(EmployeeRequest employeeRequest) {
        checkNotNull(employeeRequest, "EmployeeRequest not valid");
        int newEmployee = 0;
        checkArgument(employeeRequest.getEmployeeId() != newEmployee, "Invalid EmployeeId");
        checkArgument(StringUtils.isNotBlank(employeeRequest.getEmployeeName()), "Invalid EmployeeName");

        Trabajador e = new Trabajador();
        e.setId(employeeRequest.getEmployeeId());
        e.setNombre(employeeRequest.getEmployeeName());
        e.setDireccion(employeeRequest.getAddress());
        e.setTelefono(employeeRequest.getTel());
        int result = employeesApp.updateEmployee(e);
        if(result != 1) {
            System.out.printf("Not able to update employeeId %d.%n", employeeRequest.getEmployeeId());
            throw new WebApplicationException("Could not update employee", Response.Status.INTERNAL_SERVER_ERROR);
        }
        System.out.printf("EmployeeId %d updated successfully.%n", employeeRequest.getEmployeeId());
        return Response.ok().build();

    }

    @Override
    public Response deleteMarkerEmployee(int employeeId) {
        checkArgument(employeeId > 0, "Invalid employeeId");

        Trabajador employee = new Trabajador();
        employee.setId(employeeId);
        //todo: add validation. if user has block assigned, do not deletemark employee

        int value = employeesApp.deleteMark(employee);
        if(value != 1) {
            System.out.printf("Attempted to delete employeeId %d but it failed.%n", employeeId);
            throw new WebApplicationException("Employee was not deleted successfully",
                    Response.Status.INTERNAL_SERVER_ERROR);
        }
        System.out.printf("Employee %d was delete marked successfully.%n", employeeId);
        return Response.ok().build();
    }

    @Override
    public Response incrementNextBlockNumber(int employeeId, int blockId, int currentBlockNumber, String description) {
        checkArgument(employeeId > 0, "Invalid EmployeeId");
        checkArgument(blockId > 0, "Invalid BlockId");
        checkArgument(StringUtils.isNotBlank(description), "Invalid description");

        Optional<Trabajador> employee = employeesApp.selectOne(employeeId);
        if(!employee.isPresent()) {
            throw new WebApplicationException("Employee not found", Response.Status.NOT_FOUND);
        }

        Optional<Bloque> block = blockApp.selectOne(blockId);
        if(!block.isPresent()) {
            throw new WebApplicationException("Block not found", Response.Status.NOT_FOUND);
        }

        if(block.get().getSecuencia() != currentBlockNumber) {
            System.out.println("Current Block Number does not match to value in DB");
            throw new WebApplicationException("Bad Request", Response.Status.BAD_REQUEST);
        }

        System.out.println("About to increment blockNumber");
        int newNumber = currentBlockNumber + 1;
        System.out.printf("CurrentBlockNumber: %d, NewBlockNumber: %d.%n", currentBlockNumber, newNumber);

        Bloque b = block.get();
        b.setSecuencia(newNumber);
        if (newNumber > block.get().getNumfinal()) {
            System.out.printf("BlockId #%s has no more available notes. It will be terminated.%n", block.get().getId());
            b.setStatus(false);
        }

        if(blockApp.updateNextNumber(b) != 1) {
            System.out.printf("Not able to set newNumber %d for block %d.%n", newNumber, blockId);
            throw new WebApplicationException("Not able to set newBlockNumber", Response.Status.INTERNAL_SERVER_ERROR);
        }

        System.out.printf("About to set SerieError related to block #%d%n", blockId);
        Serieerror error = new Serieerror();
        error.setId(null);
        error.setFecharegistro(Instant.now());
        error.setNonota(String.format("%s - %d", block.get().getLetra().trim(),
                currentBlockNumber));
        error.setIdchofer(employeeId);
        error.setObservaciones(description);
        if(blockErrorApp.insertBlockError(error) != 1) {
            System.out.printf("Could not set SerieError for block %d", block.get().getId());
            throw new WebApplicationException("Error inserting SerieError", Response.Status.INTERNAL_SERVER_ERROR);
        }

        System.out.println("Block Number Updated!");
        return Response.ok().build();
    }
}
