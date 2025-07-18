package com.bit.backend.services.impl;

import com.bit.backend.dtos.CustomerLoginDto;
import com.bit.backend.dtos.EmployeeLoginDto;
import com.bit.backend.entities.CustomerLoginEntity;
import com.bit.backend.entities.EmployeeLoginEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.CustomerLoginMapper;
import com.bit.backend.repositories.CustomerLoginRepository;
import com.bit.backend.services.CustomerLoginServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public CustomerLoginDto updateCustomer(long id, CustomerLoginDto customerLoginDto) {
        try{
            Optional<CustomerLoginEntity> OptionalCustomerEntity=customerLoginRepository.findById(id);

            if(!OptionalCustomerEntity.isPresent()){
                throw new AppException("Customer does not exist", HttpStatus.BAD_REQUEST);
            }

            CustomerLoginEntity newCustomerEntity=customerLoginMapper.toCustomerLoginEntity(customerLoginDto);
            newCustomerEntity.setId(id);//To set the customerNumber of the newEntity
            newCustomerEntity.setUserId(customerLoginDto.getUserId() != null ? customerLoginDto.getUserId(): OptionalCustomerEntity.get().getUserId());
            CustomerLoginEntity savedEntity=customerLoginRepository.save(newCustomerEntity);
            CustomerLoginDto updatedDto=customerLoginMapper.toCustomerLoginDto(savedEntity);

            return updatedDto;
        }catch (Exception e){
            throw new AppException("Request failed with error" +e, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public CustomerLoginDto deleteCustomer(long id) {
        try{
            Optional<CustomerLoginEntity> OptionalCustomerEntity=customerLoginRepository.findById(id);

            if(!OptionalCustomerEntity.isPresent()){
                throw new AppException("Customer does not exist", HttpStatus.BAD_REQUEST);
            }

            customerLoginRepository.deleteById(id);

            return customerLoginMapper.toCustomerLoginDto(OptionalCustomerEntity.get());
        }
        catch (Exception e){
            throw new AppException("Request failed with error" +e, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public boolean checkIfCustomerExist(CustomerLoginDto customerLoginDto) {
        try {
            Optional<List<CustomerLoginEntity>> optionalCustomerLoginEntityList = customerLoginRepository.findByCustomerId(customerLoginDto.getCustomerId());

            if (optionalCustomerLoginEntityList.isPresent() && optionalCustomerLoginEntityList.get().size() > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            throw new AppException("Request failed with error" +e, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public CustomerLoginDto getCustomerLogin(long id) {
        try {
            Optional<CustomerLoginEntity> oCustomerLoginEntity = customerLoginRepository.findById(id);

            if (!oCustomerLoginEntity.isPresent()) {
                throw new AppException("Customer not found!", HttpStatus.BAD_REQUEST);
            }

            return customerLoginMapper.toCustomerLoginDto(oCustomerLoginEntity.get());

        } catch (Exception e) {
            throw new AppException("Error while getting customer login! Please try again", HttpStatus.BAD_REQUEST);
        }
    }
}

