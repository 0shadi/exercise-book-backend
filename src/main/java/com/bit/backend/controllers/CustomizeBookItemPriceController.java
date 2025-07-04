package com.bit.backend.controllers;

import com.bit.backend.dtos.CustomizeBookItemPriceMapDto;
import com.bit.backend.services.CustomizeBookItemPriceMapI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomizeBookItemPriceController {
    private final CustomizeBookItemPriceMapI customizeBookItemPriceMapI;

    public CustomizeBookItemPriceController(CustomizeBookItemPriceMapI customizeBookItemPriceMapI) {
        this.customizeBookItemPriceMapI = customizeBookItemPriceMapI;
    }

    @GetMapping("/customize-book-item-price-map")
    public ResponseEntity<List<CustomizeBookItemPriceMapDto>> getData() {
            List<CustomizeBookItemPriceMapDto> customizeBookItemPriceMapDtoList = this.customizeBookItemPriceMapI.getData();
            return ResponseEntity.ok(customizeBookItemPriceMapDtoList);
        }
}
