package com.bit.backend.controllers;

import com.bit.backend.dtos.CustomerLoginDto;
import com.bit.backend.dtos.EmployeeRegistrationDto;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.CustomerLoginServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
