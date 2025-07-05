package com.bit.backend.services.impl;

import com.bit.backend.dtos.*;
import com.bit.backend.entities.*;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.CustomizationPaymentDetailsMapper;
import com.bit.backend.mappers.CustomizedBillingDetailsMapper;
import com.bit.backend.mappers.CustomizedBookDetailsMapper;
import com.bit.backend.mappers.CustomizedOrderDetailsMapper;
import com.bit.backend.repositories.CustomizationPaymentDetailsRepository;
import com.bit.backend.repositories.CustomizedBillingDetailsRepository;
import com.bit.backend.repositories.CustomizedBookDetailsRepository;
import com.bit.backend.repositories.CustomizedOrderDetailsRepository;
import com.bit.backend.services.CustomizedOrderServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomizedOrderService implements CustomizedOrderServiceI {
    private final CustomizedOrderDetailsRepository customizedOrderDetailsRepository;
    private final CustomizedOrderDetailsMapper customizedOrderDetailsMapper;

    private final CustomizedBookDetailsRepository customizedBookDetailsRepository;
    private final CustomizedBookDetailsMapper customizedBookDetailsMapper;

    private final CustomizedBillingDetailsRepository customizedBillingDetailsRepository;
    private final CustomizedBillingDetailsMapper customizedBillingDetailsMapper;
    private final CustomizationPaymentDetailsMapper customizationPaymentDetailsMapper;
    private final CustomizationPaymentDetailsRepository customizationPaymentDetailsRepository;

    public CustomizedOrderService(CustomizedOrderDetailsRepository customizedOrderDetailsRepository, CustomizedOrderDetailsMapper customizedOrderDetailsMapper, CustomizedBookDetailsRepository customizedBookDetailsRepository, CustomizedBookDetailsMapper customizedBookDetailsMapper, CustomizedBillingDetailsRepository customizedBillingDetailsRepository, CustomizedBillingDetailsMapper customizedBillingDetailsMapper, CustomizationPaymentDetailsMapper customizationPaymentDetailsMapper, CustomizationPaymentDetailsRepository customizationPaymentDetailsRepository) {
        this.customizedOrderDetailsRepository = customizedOrderDetailsRepository;
        this.customizedOrderDetailsMapper = customizedOrderDetailsMapper;
        this.customizedBookDetailsRepository = customizedBookDetailsRepository;
        this.customizedBookDetailsMapper = customizedBookDetailsMapper;
        this.customizedBillingDetailsRepository = customizedBillingDetailsRepository;
        this.customizedBillingDetailsMapper = customizedBillingDetailsMapper;
        this.customizationPaymentDetailsMapper = customizationPaymentDetailsMapper;
        this.customizationPaymentDetailsRepository = customizationPaymentDetailsRepository;
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

    @Override
    public List<CustomizedOrderDetailsDto> getCustomizedOderDetailsEntity() {
        try{
            List<CustomizedOrderDetailsEntity> customizedOrderDetailsEntityList =customizedOrderDetailsRepository.findAll();
            List<CustomizedOrderDetailsDto> CustomizedOrderDtoList=customizedOrderDetailsMapper.toCustomizedOrderDetailsDtoList(customizedOrderDetailsEntityList);
            return CustomizedOrderDtoList;
        }
        catch (Exception e){
            throw new AppException("Request failed with error" +e, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<CustomizedBookDetailsDto> getCustomizedBookDetails(long orderId) {
        try {
            Optional<List<CustomizedBookDetailsEntity>> optionalEntity = customizedBookDetailsRepository.findByOrderId(orderId);

            if (!optionalEntity.isPresent()) {
                throw new AppException("Item does not exist", HttpStatus.BAD_REQUEST);
            }
            List<CustomizedBookDetailsEntity> itemEntity = optionalEntity.get();
            List<CustomizedBookDetailsDto> customizedBookDetailsDto = customizedBookDetailsMapper.toCustomizedBookDetailsDtoList(itemEntity);

            return customizedBookDetailsDto;

        } catch (Exception e) {
            throw new AppException("Request failed with error" + e, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public CustomizedOrderDetailsDto updateOrderStatus(long orderId, CustomizedOrderDetailsDto orderStatus) {
        try{
            Optional<CustomizedOrderDetailsEntity> optionalEntity=customizedOrderDetailsRepository.findByOrderId(orderId);

            if(!optionalEntity.isPresent()){
                throw new AppException("Item does not exist", HttpStatus.BAD_REQUEST);
            }

            CustomizedOrderDetailsEntity newEntity = optionalEntity.get();
            newEntity.setOrderStatus(orderStatus.getOrderStatus());

            CustomizedOrderDetailsEntity updatedEntity =customizedOrderDetailsRepository.save(newEntity);
            return customizedOrderDetailsMapper.toCustomizedOrderDetailsDto(updatedEntity);
        }
        catch (Exception e){
            throw new AppException("Request failed with error" +e, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public CustomizationPaymentDetailsDto addCustomizationPaymentDetailsEntity(CustomizationPaymentDetailsDto customizationPaymentDetailsDto) {
        try{
            CustomizationPaymentDetailsEntity customizationPaymentDetailsEntity=customizationPaymentDetailsMapper.toCustomizationPaymentDetailsEntity(customizationPaymentDetailsDto);
            CustomizationPaymentDetailsEntity saveCustomizationPaymentEntity=customizationPaymentDetailsRepository.save(customizationPaymentDetailsEntity);
            CustomizationPaymentDetailsDto savedCustomizationPaymentDto=customizationPaymentDetailsMapper.toCustomizationPaymentDetailsDto(saveCustomizationPaymentEntity);
            return savedCustomizationPaymentDto;
        }
        catch (Exception e){
            throw new AppException("Request failed with error" +e, HttpStatus.BAD_REQUEST);
        }
    }

}

