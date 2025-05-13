package com.bit.backend.services;

import com.bit.backend.dtos.BillingDetailsDto;
import com.bit.backend.dtos.OrderDetailsDto;
import com.bit.backend.dtos.OrderItemDetailsDto;

import java.util.List;

public interface CheckoutServiceI {
    BillingDetailsDto addBillingDetailsEntity(BillingDetailsDto billingDetailsDto);

    OrderDetailsDto addOrderDetailsEntity(OrderDetailsDto orderDetailsDto);

    OrderItemDetailsDto addOrderItemDetailsEntity(OrderItemDetailsDto orderItemDetailsDto);

    List<OrderDetailsDto> getOderDetailsEntity();

    List<OrderItemDetailsDto> getOrderItem(long orderId);
}
