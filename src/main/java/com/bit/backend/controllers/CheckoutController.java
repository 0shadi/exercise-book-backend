package com.bit.backend.controllers;

import com.bit.backend.dtos.BillingDetailsDto;
import com.bit.backend.dtos.OrderDetailsDto;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.CheckoutServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class CheckoutController {
    private final CheckoutServiceI checkoutServiceI;

    public CheckoutController(CheckoutServiceI checkoutServiceI) {
        this.checkoutServiceI = checkoutServiceI;
    }

    @PostMapping("/checkout-billingDetails")
    public ResponseEntity<BillingDetailsDto> addBillingDetailsEntity(@RequestBody BillingDetailsDto billingDetailsDto) {
        try{
            BillingDetailsDto billingDetailsDto1 =checkoutServiceI.addBillingDetailsEntity(billingDetailsDto);
            return ResponseEntity.created(URI.create("/checkout-billingDetails" + billingDetailsDto1.getOrderId())).body(billingDetailsDto1);
        }
        catch(Exception e){
            throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/checkout-orderDetails")
    public ResponseEntity<OrderDetailsDto> addOrderDetailsEntity(@RequestBody OrderDetailsDto orderDetailsDto) {
        try{
            OrderDetailsDto orderDetailsDto1 =checkoutServiceI.addOrderDetailsEntity(orderDetailsDto);
            return ResponseEntity.created(URI.create("/checkout-orderDetails" + orderDetailsDto1.getOrderId())).body(orderDetailsDto1);
        }
        catch(Exception e){
            throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
