package com.bit.backend.services;

import com.bit.backend.dtos.CustomerRegistrationDto;
import com.bit.backend.entities.CustomerRegistrationEntity;

import java.util.List;

public interface CustomerRegistrationServiceI {
    CustomerRegistrationDto addCustomerEntity(CustomerRegistrationDto customerRegistrationDto);

    List<CustomerRegistrationDto> getCustomerEntity();

    CustomerRegistrationDto editCustomerEntity(long customerId, CustomerRegistrationDto customerRegistrationDto);

    CustomerRegistrationDto deleteCustomerEntity(long customerId);
}
