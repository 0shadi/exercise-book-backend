package com.bit.backend.controllers;

import com.bit.backend.dtos.CustomerRegistrationDto;
import com.bit.backend.dtos.SupplierRegistrationDto;
import com.bit.backend.entities.SupplierRegistrationEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.SupplierRegistrationServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class SupplierRegistrationController {
    private final SupplierRegistrationServiceI supplierRegistrationServiceI;

    public SupplierRegistrationController(SupplierRegistrationServiceI supplierRegistrationServiceI) {
        this.supplierRegistrationServiceI = supplierRegistrationServiceI;
    }

    @PostMapping("/supplier-registration")
    public ResponseEntity<SupplierRegistrationDto> addEntity (@RequestBody SupplierRegistrationDto supplierRegistrationDto) {
        try{
            SupplierRegistrationDto supplierRegistrationResponse=supplierRegistrationServiceI.addSupplierEntity(supplierRegistrationDto);
            return ResponseEntity.created(URI.create("/supplier-registration" + supplierRegistrationResponse.getSupplierId())).body(supplierRegistrationResponse);
        }
        catch (Exception e){
            throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/supplier-registration")
    public ResponseEntity<List<SupplierRegistrationDto>> getSupplier() {
        try{
            List<SupplierRegistrationDto> supplierDtoList= supplierRegistrationServiceI.getSupplierEntity();
            return ResponseEntity.ok (supplierDtoList);
        }
        catch (Exception e){
            throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/supplier-registration/{supplierId}")
    public ResponseEntity<SupplierRegistrationDto> updateSupplier(@PathVariable long supplierId, @RequestBody SupplierRegistrationDto supplierRegistrationDto){
        try{
            SupplierRegistrationDto supplierDto= supplierRegistrationServiceI.updateSupplierEntity(supplierId, supplierRegistrationDto);
            return ResponseEntity.ok(supplierDto);
        }
        catch (Exception e){
            throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/supplier-registration/{supplierId}")
    public ResponseEntity<SupplierRegistrationDto> deleteSupplier(@PathVariable long supplierId){
        try{
            SupplierRegistrationDto deletedSupplier= supplierRegistrationServiceI.deleteSupplier(supplierId);
            return ResponseEntity.ok(deletedSupplier);
        }
        catch (Exception e){
            throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   
}
