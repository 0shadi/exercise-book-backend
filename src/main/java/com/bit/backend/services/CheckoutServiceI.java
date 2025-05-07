package com.bit.backend.services;

import com.bit.backend.dtos.BillingDetailsDto;
import com.bit.backend.dtos.OrderDetailsDto;
import com.bit.backend.dtos.OrderItemDetailsDto;

public interface CheckoutServiceI {
    BillingDetailsDto addBillingDetailsEntity(BillingDetailsDto billingDetailsDto);

    OrderDetailsDto addOrderDetailsEntity(OrderDetailsDto orderDetailsDto);

    OrderItemDetailsDto addOrderItemDetailsEntity(OrderItemDetailsDto orderItemDetailsDto);
}
