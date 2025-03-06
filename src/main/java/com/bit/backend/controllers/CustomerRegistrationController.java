package com.bit.backend.controllers;

import com.bit.backend.dtos.CustomerRegistrationDto;
import com.bit.backend.entities.CustomerRegistrationEntity;
import com.bit.backend.mappers.CustomerRegistrationMapper;
import com.bit.backend.services.CustomerRegistrationServiceI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class CustomerRegistrationController {
    private final CustomerRegistrationServiceI customerRegistrationServiceI;

    public CustomerRegistrationController(CustomerRegistrationServiceI customerRegistrationServiceI){
        this.customerRegistrationServiceI = customerRegistrationServiceI;
    }

    @PostMapping("/customer-registration")
    public ResponseEntity<CustomerRegistrationDto> addCustomer(@RequestBody CustomerRegistrationDto customerRegistrationDto){
        CustomerRegistrationDto customerRegistrationResponse=customerRegistrationServiceI.addCustomerEntity(customerRegistrationDto);
        return ResponseEntity.created(URI.create("/customer-registration" + customerRegistrationResponse.getCustomerId())).body(customerRegistrationResponse);
    }

    @GetMapping("/customer-registration")
    public ResponseEntity<List<CustomerRegistrationDto>> getCustomer() {
       List<CustomerRegistrationDto> customerDtoList =customerRegistrationServiceI.getCustomerEntity();
       return ResponseEntity.ok(customerDtoList);
    }

    @PutMapping("/customer-registration/{customerId}")
    public ResponseEntity<CustomerRegistrationDto> editCustomer(@PathVariable long customerId, @RequestBody CustomerRegistrationDto customerRegistrationDto){
        CustomerRegistrationDto editedCustomer=customerRegistrationServiceI.editCustomerEntity(customerId,customerRegistrationDto);
        return ResponseEntity.ok(editedCustomer);
    }

    @DeleteMapping("/customer-registration/{customerId}")
    public ResponseEntity<CustomerRegistrationDto> deleteCustomer(@PathVariable long customerId){
        CustomerRegistrationDto deletedCustomer=customerRegistrationServiceI.deleteCustomerEntity(customerId);
        return ResponseEntity.ok(deletedCustomer);
    }
}
