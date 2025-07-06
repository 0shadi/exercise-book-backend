package com.bit.backend.controllers;

import com.bit.backend.dtos.CustomerLoginDto;
import com.bit.backend.dtos.EmployeeLoginDto;
import com.bit.backend.dtos.EmployeeRegistrationDto;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.CustomerLoginServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class CustomerLoginController {
    private final CustomerLoginServiceI customerLoginServiceI;

    public CustomerLoginController(CustomerLoginServiceI customerLoginServiceI) {
        this.customerLoginServiceI = customerLoginServiceI;
    }

    @PostMapping("/customer-login")
    public ResponseEntity<CustomerLoginDto> addCustomerLogin(@RequestBody CustomerLoginDto customerLoginDto){
        try{
            CustomerLoginDto customerLoginDtoResponse = customerLoginServiceI.addCustomerLoginEntity(customerLoginDto);

            return ResponseEntity.created(URI.create("/customer-login" + customerLoginDtoResponse.getId())).body(customerLoginDtoResponse);

        }catch (Exception e){
            throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/customer-login")
    public ResponseEntity<List<CustomerLoginDto>> getCustomerLogin(){
        try{
            List<CustomerLoginDto> customerLoginDtoList=customerLoginServiceI.getCustomerLoginEntity();
            return ResponseEntity.ok (customerLoginDtoList);
        }catch (Exception e){
            throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/customer-login/{id}")
    public ResponseEntity<CustomerLoginDto> updateCustomer(@PathVariable long id, @RequestBody CustomerLoginDto customerLoginDto){
        try{
            CustomerLoginDto  updatedCustomer=customerLoginServiceI.updateCustomer(id,customerLoginDto);
            return ResponseEntity.ok(updatedCustomer);
        }catch (Exception e){
            throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/customer-login/{id}")
    public ResponseEntity<CustomerLoginDto> deleteCustomer(@PathVariable long id){
        try{
            CustomerLoginDto  deletedCustomer=customerLoginServiceI.deleteCustomer(id);
            return ResponseEntity.ok(deletedCustomer);
        }catch (Exception e){
            throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
