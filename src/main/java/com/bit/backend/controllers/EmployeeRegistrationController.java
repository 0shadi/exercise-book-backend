package com.bit.backend.controllers;

import com.bit.backend.dtos.EmployeeRegistrationDto;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.EmployeeRegistrationMapper;
import com.bit.backend.services.EmployeeRegistrationI;
import com.bit.backend.services.impl.EmployeeRegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class EmployeeRegistrationController {

    private final EmployeeRegistrationI employeeRegistrationServiceI;

    public EmployeeRegistrationController(EmployeeRegistrationI employeeRegistrationServiceI) {
        this.employeeRegistrationServiceI = employeeRegistrationServiceI;
    }

    @PostMapping("/employee-registration")
    public ResponseEntity<EmployeeRegistrationDto> addEmployee(@RequestBody EmployeeRegistrationDto employeeRegistrationDto){
        try{
            EmployeeRegistrationDto employeeRegistrationDtoResponse = employeeRegistrationServiceI.addEmployeeRegistrationEntity(employeeRegistrationDto);

            return ResponseEntity.created(URI.create("/employee-registration" + employeeRegistrationDtoResponse.getFullName())).body(employeeRegistrationDtoResponse);

        }catch (Exception e){
            throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employee-registration")
    public ResponseEntity<List<EmployeeRegistrationDto>> getEmployee(){
        try{
            List<EmployeeRegistrationDto> employeeDtoList=employeeRegistrationServiceI.getEmployeeEntity();
            return ResponseEntity.ok (employeeDtoList);
        }catch (Exception e){
            throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/employee-registration/{employeeNumber}")
    public ResponseEntity<EmployeeRegistrationDto> updateEmployee(@PathVariable long employeeNumber, @RequestBody EmployeeRegistrationDto employeeRegistrationDto){
       try{
           EmployeeRegistrationDto  updatedEmployee=employeeRegistrationServiceI.updateEmployee(employeeNumber,employeeRegistrationDto);
           return ResponseEntity.ok(updatedEmployee);
       }catch (Exception e){
           throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }

    @DeleteMapping("/employee-registration/{employeeNumber}")
    public ResponseEntity<EmployeeRegistrationDto> deleteEmployee(@PathVariable long employeeNumber){
        try{
            EmployeeRegistrationDto  deletedEmployee=employeeRegistrationServiceI.deleteEmployee(employeeNumber);
            return ResponseEntity.ok(deletedEmployee);
        }catch (Exception e){
            throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
