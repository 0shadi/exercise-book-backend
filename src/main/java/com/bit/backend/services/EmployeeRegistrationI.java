package com.bit.backend.services;

import com.bit.backend.dtos.EmployeeRegistrationDto;

import java.util.List;

public interface EmployeeRegistrationI {
    EmployeeRegistrationDto addEmployeeRegistrationEntity(EmployeeRegistrationDto employeeRegistrationDto);

    List<EmployeeRegistrationDto> getEmployeeEntity();

    EmployeeRegistrationDto updateEmployee(long employeeNumber, EmployeeRegistrationDto employeeRegistrationDto);

    EmployeeRegistrationDto deleteEmployee(long employeeNumber);
}
