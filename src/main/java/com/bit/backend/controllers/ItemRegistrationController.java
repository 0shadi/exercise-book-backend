package com.bit.backend.controllers;

import com.bit.backend.dtos.EmployeeRegistrationDto;
import com.bit.backend.dtos.GRNaddedDTO;
import com.bit.backend.dtos.ItemRegistrationDto;
import com.bit.backend.dtos.StockDTO;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.ItemRegistrationServiceI;
import com.bit.backend.services.StockServiceI;
import com.bit.backend.services.impl.ItemRegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class ItemRegistrationController {
    private final ItemRegistrationServiceI itemRegistrationServiceI;
    private final StockServiceI stockServiceI;

    public ItemRegistrationController(ItemRegistrationServiceI itemRegistrationServiceI, StockServiceI stockServiceI) {
        this.itemRegistrationServiceI = itemRegistrationServiceI;
        this.stockServiceI = stockServiceI;
    }

    @PostMapping("/item-registration")
    public ResponseEntity<ItemRegistrationDto> addEntity(@RequestBody ItemRegistrationDto itemRegistrationDto) {
        try {
            ItemRegistrationDto itemRegistrationResponse = itemRegistrationServiceI.addItemEntity(itemRegistrationDto);
            return ResponseEntity.created(URI.create("/item-registration" + itemRegistrationResponse.getItemId())).body(itemRegistrationResponse);
        } catch (Exception e) {
            throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/item-registration")
    public ResponseEntity<List<ItemRegistrationDto>> getAllItems() {
        try {
            List<ItemRegistrationDto> itemDtoList = itemRegistrationServiceI.getItemEntity();
            return ResponseEntity.ok(itemDtoList);
        } catch (Exception e) {
            throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/item-registration/{itemId}")
    public ResponseEntity<ItemRegistrationDto> updateItem(@RequestBody ItemRegistrationDto itemRegistrationDto, @PathVariable long itemId) {
        try {
            ItemRegistrationDto updatedItemDto = itemRegistrationServiceI.updateItemEntity(itemRegistrationDto, itemId);
            return ResponseEntity.ok(updatedItemDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/item-registration/{itemId}")
    public ResponseEntity<ItemRegistrationDto> deleteItem(@PathVariable long itemId) {
        try {
            ItemRegistrationDto deletedItemDto = itemRegistrationServiceI.deleteItemEntity(itemId);
            return ResponseEntity.ok(deletedItemDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getQty/{itemID}")
    public ResponseEntity<StockDTO> getQty(@PathVariable long itemID){
        try{

            StockDTO stockDTO = stockServiceI.getQty(itemID);
//            if (stockDTO == null) {
//                // Return 0 if no quantity found
//            }

            return ResponseEntity.ok().body(stockDTO);
        } catch (Exception e) {
            throw new AppException(" Get mapping Failed " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/stock")
    public ResponseEntity<StockDTO> addStock(@RequestBody StockDTO stockDTO){

        StockDTO stockaddedresponse = stockServiceI.addStock(stockDTO);
        return ResponseEntity.created(URI.create("/stock"+stockaddedresponse.getId())).body(stockaddedresponse);
    }

    @PutMapping("/stockupdate")
    public ResponseEntity<List<StockDTO>> updateStock(@RequestBody List<GRNaddedDTO> grNaddedDTOS) {
        try {
            List<StockDTO> stockDTOlist = stockServiceI.updateStock(grNaddedDTOS);
            return ResponseEntity.ok().body(stockDTOlist);
        } catch (Exception e) {
            throw new AppException(" PUT mapping Failed " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/stockupdateEdit")
    public ResponseEntity<StockDTO> updateStockEdit(@RequestBody GRNaddedDTO grNaddedDTOS) {
        try {
            StockDTO stockDTOlist = stockServiceI.updateStockEdit(grNaddedDTOS);
            return ResponseEntity.ok().body(stockDTOlist);
        } catch (Exception e) {
            throw new AppException(" PUT mapping Failed " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}