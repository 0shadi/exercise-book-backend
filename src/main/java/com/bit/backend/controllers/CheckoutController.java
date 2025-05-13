package com.bit.backend.controllers;

import com.bit.backend.dtos.*;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.CheckoutServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

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

    @PostMapping("/checkout-orderItemDetails")
    public ResponseEntity<OrderItemDetailsDto> addOrderItemDetailsEntity(@RequestBody OrderItemDetailsDto orderItemDetailsDto) {
        try{
            OrderItemDetailsDto orderItemDetailsDto1 =checkoutServiceI.addOrderItemDetailsEntity(orderItemDetailsDto);
            return ResponseEntity.created(URI.create("/checkout-orderItemDetails" + orderItemDetailsDto1.getId())).body(orderItemDetailsDto1);        }
        catch(Exception e){
            throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/checkout-orderDetails")
    public ResponseEntity<OrderDetailsDto> addOrderDetailsEntity(@RequestBody OrderDetailsDto orderDetailsDto) {
        try{
            OrderDetailsDto orderDetailsDto1 =checkoutServiceI.addOrderDetailsEntity(orderDetailsDto);
            return ResponseEntity.created(URI.create("/checkout-orderDetails" + orderDetailsDto1.getId())).body(orderDetailsDto1);
        }
        catch(Exception e){
            throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/order-list")
    public ResponseEntity<List<OrderDetailsDto>> getOrderList(){
        try{
            List<OrderDetailsDto> orderDetailsList=checkoutServiceI.getOderDetailsEntity();
            return ResponseEntity.ok (orderDetailsList);
        }catch (Exception e){
            throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get-order-items/{orderId}")
    public ResponseEntity<List<OrderItemDetailsDto>> getOrderItems(@PathVariable long orderId) {
        try{
            List<OrderItemDetailsDto> orderItemDetailsDto = checkoutServiceI.getOrderItem(orderId);
            return ResponseEntity.ok(orderItemDetailsDto);
        }
        catch(Exception e){
            throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
