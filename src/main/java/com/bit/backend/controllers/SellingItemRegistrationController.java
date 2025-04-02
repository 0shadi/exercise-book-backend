package com.bit.backend.controllers;

import com.bit.backend.dtos.FormDemoDto;
import com.bit.backend.dtos.SellingItemRegistrationDto;
import com.bit.backend.entities.SellingItemRegistrationEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.SellingItemRegistrationServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;
import java.util.List;

@RestController
public class SellingItemRegistrationController {
    private final SellingItemRegistrationServiceI sellingItemRegistrationServiceI;

    public SellingItemRegistrationController(SellingItemRegistrationServiceI sellingItemRegistrationServiceI) {
        this.sellingItemRegistrationServiceI = sellingItemRegistrationServiceI;
    }

    @PostMapping(value = {"/selling-item-registration"}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<SellingItemRegistrationDto> addEntity(@RequestPart("sellingItemForm") SellingItemRegistrationDto sellingItemRegistrationDto, @RequestPart("itemImage") MultipartFile file) {
        try{
            if (file != null && !file.isEmpty()) {
                sellingItemRegistrationDto.setItemImage(file.getBytes());
                sellingItemRegistrationDto.setImageName(file.getOriginalFilename());
                sellingItemRegistrationDto.setImageType(file.getContentType());
            } else {
                throw new AppException("Item image file is missing", HttpStatus.BAD_REQUEST);
            }

            SellingItemRegistrationDto sellingItemRegistrationResponse = sellingItemRegistrationServiceI.addSellingItemEntity(sellingItemRegistrationDto);
            return ResponseEntity.created(URI.create("/selling-item-registration/" + sellingItemRegistrationResponse.getItemId())).body(sellingItemRegistrationResponse);
        }
        catch(Exception e){
            throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/selling-item-registration")
    public ResponseEntity<List<SellingItemRegistrationDto>> getAllSellingItemRegistrations() {
        try{
            List<SellingItemRegistrationDto> sellingItemRegistrationDtoList = sellingItemRegistrationServiceI.getSellingItemEntity();
            return ResponseEntity.ok(sellingItemRegistrationDtoList);
        }
        catch(Exception e){
            throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/selling-item-registration/{itemId}")
    public ResponseEntity<SellingItemRegistrationDto> updateSellingItemRegistrations(@PathVariable long itemId, @RequestPart("sellingItemForm") SellingItemRegistrationDto sellingItemRegistrationDto, @RequestPart("itemImage") MultipartFile file){
        try{
            sellingItemRegistrationDto.setItemImage(file.getBytes());
            sellingItemRegistrationDto.setImageName(file.getOriginalFilename());
            sellingItemRegistrationDto.setImageType(file.getContentType());

            SellingItemRegistrationDto updatedSellingItemDto = sellingItemRegistrationServiceI.updateSellingItemEntity(sellingItemRegistrationDto,itemId);
            return ResponseEntity.ok(updatedSellingItemDto);
        }
        catch(Exception e){
            throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/selling-item-registration/{itemId}")
    public ResponseEntity<SellingItemRegistrationDto> deleteSellingItemRegistrations(@PathVariable long itemId){
        try{
            SellingItemRegistrationDto deletedSellingItemDto = sellingItemRegistrationServiceI.deleteSellingItemEntity(itemId);
            return ResponseEntity.ok(deletedSellingItemDto);
        }
        catch(Exception e){
            throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
