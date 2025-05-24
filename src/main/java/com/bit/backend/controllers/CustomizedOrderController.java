package com.bit.backend.controllers;

import com.bit.backend.dtos.CustomizedBillingDetailsDto;
import com.bit.backend.dtos.CustomizedBookDetailsDto;
import com.bit.backend.dtos.CustomizedOrderDetailsDto;
import com.bit.backend.dtos.SellingItemRegistrationDto;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.CustomizedOrderServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;

@RestController
public class CustomizedOrderController {
    private final CustomizedOrderServiceI customizedOrderServiceI;

    public CustomizedOrderController(CustomizedOrderServiceI customizedOrderService) {
        this.customizedOrderServiceI = customizedOrderService;
    }

    @PostMapping("/customization-orderDetails")
    public ResponseEntity<CustomizedOrderDetailsDto> saveOrderDetails(@RequestBody CustomizedOrderDetailsDto customizedOrderDetailsDto) {
        try{
            CustomizedOrderDetailsDto orderDetailsDto = customizedOrderServiceI.saveOrderDetailsEntity(customizedOrderDetailsDto);
            return ResponseEntity.created(URI.create("/customization-orderDetails" + orderDetailsDto.getOrderId())).body(orderDetailsDto);
        }
        catch(Exception e){
            throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = {"/customization-bookDetails"}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<CustomizedBookDetailsDto> saveBookDetails(@RequestPart("bookForm") CustomizedBookDetailsDto customizedBookDetailsDto, @RequestPart("coverPhoto") MultipartFile file) {
        try{
            if (file != null && !file.isEmpty()) {
                customizedBookDetailsDto.setCoverPhoto(file.getBytes());
            } else {
                throw new AppException("Item image file is missing", HttpStatus.BAD_REQUEST);
            }

            CustomizedBookDetailsDto bookDetailsDto = customizedOrderServiceI.saveBookDetailsEntity(customizedBookDetailsDto);
            return ResponseEntity.created(URI.create("/customization-bookDetails" + bookDetailsDto.getId())).body(bookDetailsDto);
        }
        catch(Exception e){
            throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/customization-billingDetails")
    public ResponseEntity<CustomizedBillingDetailsDto> saveBillingDetails(@RequestBody CustomizedBillingDetailsDto customizedBillingDetailsDto) {
        try{
            CustomizedBillingDetailsDto billingDetailsDto = customizedOrderServiceI.saveBillingDetailsEntity(customizedBillingDetailsDto);
            return ResponseEntity.created(URI.create("/customization-billingDetails" + billingDetailsDto.getId())).body(billingDetailsDto);
        }
        catch(Exception e){
            throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
