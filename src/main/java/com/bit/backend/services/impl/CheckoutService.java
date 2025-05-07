package com.bit.backend.services.impl;

import com.bit.backend.dtos.BillingDetailsDto;
import com.bit.backend.dtos.OrderDetailsDto;
import com.bit.backend.dtos.OrderItemDetailsDto;
import com.bit.backend.entities.BillingDetailsEntity;
import com.bit.backend.entities.OrderDetailsEntity;
import com.bit.backend.entities.OrderItemDetailsEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.BillingDetailsMapper;
import com.bit.backend.mappers.OrderDetailsMapper;
import com.bit.backend.mappers.OrderItemDetailsMapper;
import com.bit.backend.repositories.BillingDetailsRepository;
import com.bit.backend.repositories.OrderDetailsRepository;
import com.bit.backend.repositories.OrderItemDetailsRepository;
import com.bit.backend.services.CheckoutServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CheckoutService implements CheckoutServiceI {
    private final BillingDetailsRepository billingDetailsRepository;
    private final BillingDetailsMapper billingDetailsMapper;
    private final OrderDetailsRepository orderDetailsRepository;
    private final OrderDetailsMapper orderDetailsMapper;
    private final OrderItemDetailsRepository orderItemDetailsRepository;
    private final OrderItemDetailsMapper orderItemDetailsMapper;

    public CheckoutService(BillingDetailsRepository billingDetailsRepository, BillingDetailsMapper billingDetailsMapper, OrderDetailsRepository orderDetailsRepository, OrderDetailsMapper orderDetailsMapper, OrderItemDetailsRepository orderItemDetailsRepository, OrderItemDetailsMapper orderItemDetailsMapper) {
        this.billingDetailsRepository = billingDetailsRepository;
        this.billingDetailsMapper = billingDetailsMapper;
        this.orderDetailsRepository = orderDetailsRepository;
        this.orderDetailsMapper = orderDetailsMapper;
        this.orderItemDetailsRepository = orderItemDetailsRepository;
        this.orderItemDetailsMapper = orderItemDetailsMapper;
    }

    @Override
    public BillingDetailsDto addBillingDetailsEntity(BillingDetailsDto billingDetailsDto) {
        try{
            BillingDetailsEntity billingDetailsEntity=billingDetailsMapper.toBillingDetailsEntity(billingDetailsDto);
            BillingDetailsEntity savedEntity=billingDetailsRepository.save(billingDetailsEntity);
            BillingDetailsDto savedDto=billingDetailsMapper.toToBillingDetailsDto(savedEntity);
            return savedDto;
        }
        catch (Exception e){
            throw new AppException("Request failed with error" +e, HttpStatus.BAD_REQUEST);
        }}

    @Override
    public OrderDetailsDto addOrderDetailsEntity(OrderDetailsDto orderDetailsDto) {
        try{
            OrderDetailsEntity orderDetailsEntity=orderDetailsMapper.toOrderDetailsEntity(orderDetailsDto);
            OrderDetailsEntity savedOrderEntity=orderDetailsRepository.save(orderDetailsEntity);
            OrderDetailsDto savedOrderDto=orderDetailsMapper.toOrderDetailsDto(savedOrderEntity);
            return savedOrderDto;
        }
        catch (Exception e){
            throw new AppException("Request failed with error" +e, HttpStatus.BAD_REQUEST);
        }}

    @Override
    public OrderItemDetailsDto addOrderItemDetailsEntity(OrderItemDetailsDto orderItemDetailsDto) {
        try{
            OrderItemDetailsEntity orderItemDetailsEntity=orderItemDetailsMapper.toOrderItemDetailsEntity(orderItemDetailsDto);
            OrderItemDetailsEntity savedOrderItemEntity=orderItemDetailsRepository.save(orderItemDetailsEntity);
            OrderItemDetailsDto savedOrderItemDto=orderItemDetailsMapper.toOrderItemDetailsDto(savedOrderItemEntity);
            return savedOrderItemDto;
        }
        catch (Exception e){
            throw new AppException("Request failed with error" +e, HttpStatus.BAD_REQUEST);
        }}
}
