package com.bit.backend.services.impl;

import com.bit.backend.dtos.CustomerRegistrationDto;
import com.bit.backend.entities.CustomerRegistrationEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.CustomerRegistrationMapper;
import com.bit.backend.repositories.CustomerRegistrationRepository;
import com.bit.backend.services.CustomerRegistrationServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerRegistrationService implements CustomerRegistrationServiceI {
    private final CustomerRegistrationRepository customerRegistrationRepository;
    private final CustomerRegistrationMapper customerRegistrationMapper;

    public CustomerRegistrationService(CustomerRegistrationRepository customerRegistrationRepository,CustomerRegistrationMapper customerRegistrationMapper) {
        this.customerRegistrationRepository = customerRegistrationRepository;
        this.customerRegistrationMapper = customerRegistrationMapper;
    }

    @Override
    public CustomerRegistrationDto addCustomerEntity(CustomerRegistrationDto customerRegistrationDto) {
        try{
            CustomerRegistrationEntity customerRegistrationEntity = customerRegistrationMapper.toCustomerRegistrationEntity(customerRegistrationDto);
            CustomerRegistrationEntity savedEntity = customerRegistrationRepository.save(customerRegistrationEntity);
            CustomerRegistrationDto savedDto = customerRegistrationMapper.toCustomerRegistrationDto(savedEntity);
            return savedDto;
        }
        catch (Exception e){
            throw new AppException("Request failed with error" +e, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<CustomerRegistrationDto> getCustomerEntity() {
        try{
            List<CustomerRegistrationEntity> customerEntityList=customerRegistrationRepository.findAll();
            List<CustomerRegistrationDto> customerDtoList=customerRegistrationMapper.toCustomerRegistrationDtoList(customerEntityList);
            return customerDtoList;
        }
        catch (Exception e){
            throw new AppException("Request failed with error" +e, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public CustomerRegistrationDto editCustomerEntity(long customerId, CustomerRegistrationDto customerRegistrationDto) {
        try{
            Optional<CustomerRegistrationEntity> optionalEntity=customerRegistrationRepository.findById(customerId);

            if(!optionalEntity.isPresent()) {
                throw new AppException("Customer does not exist", HttpStatus.BAD_REQUEST);
            }

            CustomerRegistrationEntity newEntity= customerRegistrationMapper.toCustomerRegistrationEntity(customerRegistrationDto);
            newEntity.setCustomerId(customerId);
            CustomerRegistrationEntity savedEntity = customerRegistrationRepository.save(newEntity);
            CustomerRegistrationDto savedDto = customerRegistrationMapper.toCustomerRegistrationDto(savedEntity);
            return savedDto;
        }
        catch (Exception e){
            throw new AppException("Request failed with error" +e, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public CustomerRegistrationDto deleteCustomerEntity(long customerId) {
       try{
           Optional<CustomerRegistrationEntity> optionalEntity=customerRegistrationRepository.findById(customerId);
           if(!optionalEntity.isPresent()) {
               throw new AppException("Customer does not exist", HttpStatus.BAD_REQUEST);
           }

           customerRegistrationRepository.deleteById(customerId);
           return customerRegistrationMapper.toCustomerRegistrationDto(optionalEntity.get());
       }
       catch (Exception e){
           throw new AppException("Request failed with error" +e, HttpStatus.BAD_REQUEST);
       }
    }

    @Override
    public CustomerRegistrationDto addCustomerEntityOnUserRegister(CustomerRegistrationDto customerRegistrationDto) {
        CustomerRegistrationEntity customerRegistrationEntity = customerRegistrationMapper.toCustomerRegistrationEntity(customerRegistrationDto);
        CustomerRegistrationEntity savedEntity = customerRegistrationRepository.save(customerRegistrationEntity);
        CustomerRegistrationDto savedDto = customerRegistrationMapper.toCustomerRegistrationDto(savedEntity);
        return savedDto;
    }

}

