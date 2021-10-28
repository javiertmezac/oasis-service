package com.jtmc.apps.oasis.api.v1.employees;

import java.util.List;

public class EmployeeResponseList {
    private List<EmployeeResponse> employeeList;

    public List<EmployeeResponse> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<EmployeeResponse> employeeList) {
        this.employeeList = employeeList;
    }
}
