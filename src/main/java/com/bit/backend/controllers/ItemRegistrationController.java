package com.bit.backend.controllers;

import com.bit.backend.dtos.EmployeeRegistrationDto;
import com.bit.backend.dtos.ItemRegistrationDto;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.ItemRegistrationServiceI;
import com.bit.backend.services.impl.ItemRegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class ItemRegistrationController {
    private final ItemRegistrationServiceI itemRegistrationServiceI;

    public ItemRegistrationController(ItemRegistrationServiceI itemRegistrationServiceI) {
        this.itemRegistrationServiceI = itemRegistrationServiceI;
    }

    @PostMapping("/item-registration")
    public ResponseEntity<ItemRegistrationDto> addEntity(@RequestBody ItemRegistrationDto itemRegistrationDto) {
        try{
            ItemRegistrationDto itemRegistrationResponse =itemRegistrationServiceI.addItemEntity(itemRegistrationDto);
            return ResponseEntity.created(URI.create("/item-registration" + itemRegistrationResponse.getItemId())).body(itemRegistrationResponse);
        }
        catch(Exception e){
            throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/item-registration")
    public ResponseEntity<List<ItemRegistrationDto>> getAllItems() {
        try{
            List<ItemRegistrationDto> itemDtoList = itemRegistrationServiceI.getItemEntity();
            return ResponseEntity.ok(itemDtoList);
        }
        catch(Exception e){
            throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/item-registration/{itemId}")
    public ResponseEntity<ItemRegistrationDto> updateItem(@RequestBody ItemRegistrationDto itemRegistrationDto, @PathVariable long itemId) {
       try{
           ItemRegistrationDto updatedItemDto =itemRegistrationServiceI.updateItemEntity(itemRegistrationDto,itemId);
           return ResponseEntity.ok(updatedItemDto);
       }
       catch(Exception e){
           throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }

    @DeleteMapping("/item-registration/{itemId}")
    public ResponseEntity<ItemRegistrationDto> deleteItem(@PathVariable long itemId) {
       try{ ItemRegistrationDto deletedItemDto=itemRegistrationServiceI.deleteItemEntity(itemId);
           return ResponseEntity.ok(deletedItemDto);
    }
       catch(Exception e){
           throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
       }
}}
