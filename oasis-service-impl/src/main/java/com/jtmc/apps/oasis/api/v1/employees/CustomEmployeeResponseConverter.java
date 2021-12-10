package com.jtmc.apps.oasis.api.v1.employees;

import com.jtmc.apps.oasis.domain.CustomEmployee;

import java.util.function.Function;

public class CustomEmployeeResponseConverter implements Function<CustomEmployee, EmployeeResponse> {

    @Override
    public EmployeeResponse apply(CustomEmployee trabajador) {
        EmployeeResponse response = new EmployeeResponse();
        response.setEmployeeId(trabajador.getId());
        response.setEmployeeName(trabajador.getNombre());
        response.setTel(trabajador.getTelefono());
        response.setAddress(trabajador.getDireccion());
        response.setRegistration(trabajador.getFecharegistro());

        if (trabajador.getNextBlockNumber() != null) {
            response.setBlockNumber(String.valueOf(trabajador.getNextBlockNumber()));
            response.setBlock(String.format("%s %d - %d", trabajador.getLetter(),
                    trabajador.getBlockStartNumber(), trabajador.getBlockEndNumber())
            );
            response.setNote(String.format("%s - %s", trabajador.getLetter(), trabajador.getNextBlockNumber()));
            response.setBlockId(trabajador.getBlockId());
        } else {
            String statusText = "n/a";
            response.setNote(statusText);
            response.setBlock(statusText);
            response.setBlockNumber(statusText);
        }
        return response;
    }
}
