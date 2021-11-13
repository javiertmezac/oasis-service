package com.jtmc.apps.oasis.api.v1.employees;

import com.jtmc.apps.oasis.domain.CustomEmployee;

import java.util.function.Function;

public class CustomEmployeeResponseConverter implements Function<CustomEmployee, EmployeeResponse> {

    @Override
    public EmployeeResponse apply(CustomEmployee trabajador) {
        EmployeeResponse response = new EmployeeResponse();
        response.setEmployeeId(trabajador.getId());
        response.setEmployeeName(trabajador.getNombre());

        response.setNote(String.format("%s - %s", trabajador.getLetter(), trabajador.getNextBlockNumber()));
        return response;
    }
}
