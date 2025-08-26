package com.bit.backend.controllers;

import com.bit.backend.dtos.ProductItemsDto;
import com.bit.backend.dtos.ProductItemsMapDto;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.ProductItemsMapServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class ProductItemsMapController {

    private final ProductItemsMapServiceI productItemsMapServiceI;

    public ProductItemsMapController(ProductItemsMapServiceI productItemsMapServiceI) {
        this.productItemsMapServiceI = productItemsMapServiceI;
    }

    @PostMapping("/product-items-map")
    public ResponseEntity<ProductItemsMapDto> addProductItemMap(@RequestBody ProductItemsMapDto productItemsMapDto) {
        try {
            ProductItemsMapDto responseProductItemsMapDtp = this.productItemsMapServiceI.addProductItemMap(productItemsMapDto);
            return ResponseEntity.created(URI.create("product_items_map" + responseProductItemsMapDtp.getProduct())).body(responseProductItemsMapDtp);
        } catch (Exception e) {
            throw new AppException("Request Failed with Error:" + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/product-items-map")
    public ResponseEntity<List<ProductItemsMapDto>> getData(){
        try {
            List<ProductItemsMapDto> productItemsMapDtoList = productItemsMapServiceI.getData();
            return ResponseEntity.ok(productItemsMapDtoList);
        } catch (Exception e){
            throw new AppException("Request Failed with Error:" + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/product-items-map/{id}")
    public ResponseEntity<ProductItemsMapDto> updateProductItemMap(@PathVariable long id, @RequestBody ProductItemsMapDto productItemsMapDto) {
        try {
            ProductItemsMapDto responseProductItemsMapDtp = this.productItemsMapServiceI.updateProductItemMap(id, productItemsMapDto);
            return ResponseEntity.created(URI.create("product_items_map" + responseProductItemsMapDtp.getProduct())).body(responseProductItemsMapDtp);
        } catch (Exception e) {
            throw new AppException("Request Failed with Error:" + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
