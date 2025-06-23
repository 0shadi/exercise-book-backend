package com.bit.backend.services.impl;

import com.bit.backend.dtos.CustomerLoginDto;
import com.bit.backend.entities.CustomerLoginEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.CustomerLoginMapper;
import com.bit.backend.repositories.CustomerLoginRepository;
import com.bit.backend.services.CustomerLoginServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerLoginService implements CustomerLoginServiceI {
    private final CustomerLoginMapper customerLoginMapper;
    private final CustomerLoginRepository customerLoginRepository;

    public CustomerLoginService(CustomerLoginMapper customerLoginMapper, CustomerLoginRepository customerLoginRepository) {
        this.customerLoginMapper = customerLoginMapper;
        this.customerLoginRepository = customerLoginRepository;
    }

    @Override
    public CustomerLoginDto addCustomerLoginEntity(CustomerLoginDto customerLoginDto) {
        try{
            CustomerLoginEntity customerLoginEntity =customerLoginMapper.toCustomerLoginEntity(customerLoginDto);
            CustomerLoginEntity savedEntity=customerLoginRepository.save(customerLoginEntity );
            CustomerLoginDto savedDto = customerLoginMapper.toCustomerLoginDto(savedEntity);

            return savedDto;
        }catch(Exception e){
            throw new AppException("Request failed with error" +e, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<CustomerLoginDto> getCustomerLoginEntity() {
        try{
            List<CustomerLoginEntity>  customerLoginEntityList=customerLoginRepository.findAll();
            List<CustomerLoginDto> customerLoginDtoList=customerLoginMapper.toCustomerLoginDtoList(customerLoginEntityList);

            return customerLoginDtoList;
        }catch (Exception e){
            throw new AppException("Request failed with error" +e, HttpStatus.BAD_REQUEST);
        }
    }
}
