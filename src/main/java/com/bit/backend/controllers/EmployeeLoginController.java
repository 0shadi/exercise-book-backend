package com.bit.backend.controllers;

import com.bit.backend.dtos.EmployeeLoginDto;
import com.bit.backend.dtos.EmployeeRegistrationDto;
import com.bit.backend.dtos.ItemRegistrationDto;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.EmployeeLoginServiceI;
import com.bit.backend.services.impl.EmployeeLoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class EmployeeLoginController {
    private final EmployeeLoginServiceI employeeLoginServiceI;

    public EmployeeLoginController(EmployeeLoginServiceI employeeLoginServiceI) {
        this.employeeLoginServiceI = employeeLoginServiceI;
    }

    @PostMapping("/employee-login")
    public ResponseEntity<EmployeeLoginDto> addEntity(@RequestBody EmployeeLoginDto employeeLoginDto) {
        try{
            EmployeeLoginDto employeeLoginResponse =employeeLoginServiceI.addEmployeeLoginEntity(employeeLoginDto);
            return ResponseEntity.created(URI.create("/employee-login" + employeeLoginResponse.getId())).body(employeeLoginResponse);
        }
        catch(Exception e){
            throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employee-login")
    public ResponseEntity<List<EmployeeLoginDto>> getEntity(){
        try{
            List<EmployeeLoginDto> employeeLoginList=employeeLoginServiceI.getEmployeeLoginEntity();
            return ResponseEntity.ok (employeeLoginList);
        }catch (Exception e){
            throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/employee-login/{id}")
    public ResponseEntity<EmployeeLoginDto> updateEmployee(@PathVariable long id, @RequestBody EmployeeLoginDto employeeLoginDto){
        try{
            EmployeeLoginDto  updatedEmployee=employeeLoginServiceI.updateEmployee(id,employeeLoginDto);
            return ResponseEntity.ok(updatedEmployee);
        }catch (Exception e){
            throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/employee-login/{id}")
    public ResponseEntity<EmployeeLoginDto> deleteEmployee(@PathVariable long id){
        try{
            EmployeeLoginDto  deletedEmployee=employeeLoginServiceI.deleteEmployee(id);
            return ResponseEntity.ok(deletedEmployee);
        }catch (Exception e){
            throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
