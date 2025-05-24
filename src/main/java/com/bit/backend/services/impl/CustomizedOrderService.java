package com.bit.backend.services.impl;

import com.bit.backend.dtos.BillingDetailsDto;
import com.bit.backend.dtos.CustomizedBillingDetailsDto;
import com.bit.backend.dtos.CustomizedBookDetailsDto;
import com.bit.backend.dtos.CustomizedOrderDetailsDto;
import com.bit.backend.entities.BillingDetailsEntity;
import com.bit.backend.entities.CustomizedBillingDetailsEntity;
import com.bit.backend.entities.CustomizedBookDetailsEntity;
import com.bit.backend.entities.CustomizedOrderDetailsEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.CustomizedBillingDetailsMapper;
import com.bit.backend.mappers.CustomizedBookDetailsMapper;
import com.bit.backend.mappers.CustomizedOrderDetailsMapper;
import com.bit.backend.repositories.CustomizedBillingDetailsRepository;
import com.bit.backend.repositories.CustomizedBookDetailsRepository;
import com.bit.backend.repositories.CustomizedOrderDetailsRepository;
import com.bit.backend.services.CustomizedOrderServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CustomizedOrderService implements CustomizedOrderServiceI {
    private final CustomizedOrderDetailsRepository customizedOrderDetailsRepository;
    private final CustomizedOrderDetailsMapper customizedOrderDetailsMapper;

    private final CustomizedBookDetailsRepository customizedBookDetailsRepository;
    private final CustomizedBookDetailsMapper customizedBookDetailsMapper;

    private final CustomizedBillingDetailsRepository customizedBillingDetailsRepository;
    private final CustomizedBillingDetailsMapper customizedBillingDetailsMapper;

    public CustomizedOrderService(CustomizedOrderDetailsRepository customizedOrderDetailsRepository, CustomizedOrderDetailsMapper customizedOrderDetailsMapper, CustomizedBookDetailsRepository customizedBookDetailsRepository, CustomizedBookDetailsMapper customizedBookDetailsMapper, CustomizedBillingDetailsRepository customizedBillingDetailsRepository, CustomizedBillingDetailsMapper customizedBillingDetailsMapper) {
        this.customizedOrderDetailsRepository = customizedOrderDetailsRepository;
        this.customizedOrderDetailsMapper = customizedOrderDetailsMapper;
        this.customizedBookDetailsRepository = customizedBookDetailsRepository;
        this.customizedBookDetailsMapper = customizedBookDetailsMapper;
        this.customizedBillingDetailsRepository = customizedBillingDetailsRepository;
        this.customizedBillingDetailsMapper = customizedBillingDetailsMapper;
    }

    @Override
    public CustomizedOrderDetailsDto saveOrderDetailsEntity(CustomizedOrderDetailsDto customizedOrderDetailsDto) {
        try{
            CustomizedOrderDetailsEntity orderDetailsEntity=customizedOrderDetailsMapper.toCustomizedOrderDetailsEntity(customizedOrderDetailsDto);
            CustomizedOrderDetailsEntity savedEntity=customizedOrderDetailsRepository.save(orderDetailsEntity);
            CustomizedOrderDetailsDto savedDto=customizedOrderDetailsMapper.toCustomizedOrderDetailsDto(savedEntity);
            return savedDto;
        }
        catch (Exception e){
            throw new AppException("Request failed with error" +e, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public CustomizedBookDetailsDto saveBookDetailsEntity(CustomizedBookDetailsDto customizedBookDetailsDto) {
        try{
            CustomizedBookDetailsEntity bookDetailsEntity=customizedBookDetailsMapper.toCustomizedBookDetailsEntity(customizedBookDetailsDto);
            CustomizedBookDetailsEntity savedEntity=customizedBookDetailsRepository.save(bookDetailsEntity);
            CustomizedBookDetailsDto savedDto=customizedBookDetailsMapper.toCustomizedBookDetailsDto(savedEntity);
            return savedDto;
        }
        catch (Exception e){
            throw new AppException("Request failed with error" +e, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public CustomizedBillingDetailsDto saveBillingDetailsEntity(CustomizedBillingDetailsDto customizedBillingDetailsDto) {
        try{
            CustomizedBillingDetailsEntity billingDetailsEntity=customizedBillingDetailsMapper.toCustomizedBillingDetailsEntity(customizedBillingDetailsDto);
            CustomizedBillingDetailsEntity savedEntity=customizedBillingDetailsRepository.save(billingDetailsEntity);
            CustomizedBillingDetailsDto savedDto=customizedBillingDetailsMapper.toCustomizedBillingDetailsDto(savedEntity);
            return savedDto;
        }
        catch (Exception e){
            throw new AppException("Request failed with error" +e, HttpStatus.BAD_REQUEST);
        }
    }

}

