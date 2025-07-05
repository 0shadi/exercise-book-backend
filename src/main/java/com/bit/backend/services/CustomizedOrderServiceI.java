package com.bit.backend.services;

import com.bit.backend.dtos.CustomizationPaymentDetailsDto;
import com.bit.backend.dtos.CustomizedBillingDetailsDto;
import com.bit.backend.dtos.CustomizedBookDetailsDto;
import com.bit.backend.dtos.CustomizedOrderDetailsDto;

import java.util.List;

public interface CustomizedOrderServiceI {
    CustomizedOrderDetailsDto saveOrderDetailsEntity(CustomizedOrderDetailsDto customizedOrderDetailsDto);

    CustomizedBookDetailsDto saveBookDetailsEntity(CustomizedBookDetailsDto customizedBookDetailsDto);

    CustomizedBillingDetailsDto saveBillingDetailsEntity(CustomizedBillingDetailsDto customizedBillingDetailsDto);

    List<CustomizedOrderDetailsDto> getCustomizedOderDetailsEntity();

    List<CustomizedBookDetailsDto> getCustomizedBookDetails(long orderId);

    CustomizedOrderDetailsDto updateOrderStatus(long orderId, CustomizedOrderDetailsDto orderStatus);

    CustomizationPaymentDetailsDto addCustomizationPaymentDetailsEntity(CustomizationPaymentDetailsDto customizationPaymentDetailsDto);
}
