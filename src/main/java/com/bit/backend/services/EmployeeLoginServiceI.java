package com.bit.backend.services;

import com.bit.backend.dtos.EmployeeLoginDto;

import java.util.List;

public interface EmployeeLoginServiceI {
    EmployeeLoginDto addEmployeeLoginEntity(EmployeeLoginDto employeeLoginDto);

    List<EmployeeLoginDto> getEmployeeLoginEntity();

    EmployeeLoginDto updateEmployee(long id, EmployeeLoginDto employeeLoginDto);

    EmployeeLoginDto deleteEmployee(long id);
}
