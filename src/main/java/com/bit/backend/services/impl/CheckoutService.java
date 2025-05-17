package com.bit.backend.services.impl;

import com.bit.backend.dtos.*;
import com.bit.backend.entities.*;
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

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<OrderDetailsDto> getOderDetailsEntity() {
        try{
            List<OrderDetailsEntity> orderEntityList =orderDetailsRepository.findAll();
            List<OrderDetailsDto> orderDtoList=orderDetailsMapper.toOrderDetailsDtoList(orderEntityList);
            return orderDtoList;
        }
        catch (Exception e){
            throw new AppException("Request failed with error" +e, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<OrderItemDetailsDto> getOrderItem(long orderId) {
        try {
            Optional<List<OrderItemDetailsEntity>> optionalEntity = orderItemDetailsRepository.findByOrderId(orderId);

            if (!optionalEntity.isPresent()) {
                throw new AppException("Item does not exist", HttpStatus.BAD_REQUEST);
            }
            List<OrderItemDetailsEntity> itemEntity = optionalEntity.get();
            List<OrderItemDetailsDto> orderItemDetailsDto = orderItemDetailsMapper.toOrderItemDetailsDtoList(itemEntity);

            return orderItemDetailsDto;

        } catch (Exception e) {
            throw new AppException("Request failed with error" + e, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public OrderDetailsDto updateOrderStatus(long orderId, OrderDetailsDto orderStatus) {
        try{
            Optional<OrderDetailsEntity> optionalEntity=orderDetailsRepository.findByOrderId(orderId);

            if(!optionalEntity.isPresent()){
                throw new AppException("Item does not exist", HttpStatus.BAD_REQUEST);
            }

            OrderDetailsEntity newEntity = optionalEntity.get();
            newEntity.setOrderStatus(orderStatus.getOrderStatus());

            OrderDetailsEntity updatedEntity =orderDetailsRepository.save(newEntity);
            return orderDetailsMapper.toOrderDetailsDto(updatedEntity);
        }
        catch (Exception e){
            throw new AppException("Request failed with error" +e, HttpStatus.BAD_REQUEST);
        }
    }
}

