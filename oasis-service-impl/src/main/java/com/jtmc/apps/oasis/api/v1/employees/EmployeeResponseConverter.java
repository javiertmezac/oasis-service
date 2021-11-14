package com.jtmc.apps.oasis.api.v1.employees;

import com.jtmc.apps.oasis.domain.Trabajador;

import java.util.function.Function;

public class EmployeeResponseConverter implements Function<Trabajador, EmployeeResponse> {

    @Override
    public EmployeeResponse apply(Trabajador trabajador) {
        EmployeeResponse response = new EmployeeResponse();
        response.setEmployeeId(trabajador.getId());
        response.setEmployeeName(trabajador.getNombre());
        response.setTel(trabajador.getTelefono());
        return response;
    }
}
