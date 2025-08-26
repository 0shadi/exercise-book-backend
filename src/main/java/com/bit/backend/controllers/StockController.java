package com.bit.backend.controllers;

import com.bit.backend.dtos.EmployeeRegistrationDto;
import com.bit.backend.dtos.StockDTO;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.EmployeeRegistrationI;
import com.bit.backend.services.StockServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StockController {
    private final StockServiceI stockServiceI;

    public StockController(StockServiceI stockServiceI) {
        this.stockServiceI = stockServiceI;
    }

    @GetMapping("/stock-update")
    public ResponseEntity<List<StockDTO>> getStock(){
        try{
            List<StockDTO> stockDtoList=stockServiceI.getData();
            return ResponseEntity.ok (stockDtoList);
        }catch (Exception e){
            throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/stock-update/{stockItemID}")
    public ResponseEntity<StockDTO> updateStock(@PathVariable int stockItemID, @RequestBody StockDTO stockDTO){
        try{
            StockDTO  updatedStock=stockServiceI.updateStockQty(stockItemID,stockDTO);
            return ResponseEntity.ok(updatedStock);
        }catch (Exception e){
            throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
