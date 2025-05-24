package com.bit.backend.services;

import com.bit.backend.dtos.CustomizedBillingDetailsDto;
import com.bit.backend.dtos.CustomizedBookDetailsDto;
import com.bit.backend.dtos.CustomizedOrderDetailsDto;

public interface CustomizedOrderServiceI {
    CustomizedOrderDetailsDto saveOrderDetailsEntity(CustomizedOrderDetailsDto customizedOrderDetailsDto);

    CustomizedBookDetailsDto saveBookDetailsEntity(CustomizedBookDetailsDto customizedBookDetailsDto);

    CustomizedBillingDetailsDto saveBillingDetailsEntity(CustomizedBillingDetailsDto customizedBillingDetailsDto);
}
