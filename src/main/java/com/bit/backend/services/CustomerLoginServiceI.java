package com.bit.backend.services;

import com.bit.backend.dtos.CustomerLoginDto;

import java.util.List;

public interface CustomerLoginServiceI {
    CustomerLoginDto addCustomerLoginEntity(CustomerLoginDto customerLoginDto);

    List<CustomerLoginDto> getCustomerLoginEntity();

    CustomerLoginDto updateCustomer(long id, CustomerLoginDto customerLoginDto);

    CustomerLoginDto deleteCustomer(long id);

    boolean checkIfCustomerExist(CustomerLoginDto customerLoginDto);
}
