package com.bit.backend.services.impl;

import com.bit.backend.dtos.SupplierRegistrationDto;
import com.bit.backend.entities.CustomerRegistrationEntity;
import com.bit.backend.entities.ItemRegistrationEntity;
import com.bit.backend.entities.SupplierRegistrationEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.SupplierRegistrationMapper;
import com.bit.backend.repositories.SupplierRegistrationRepository;
import com.bit.backend.services.SupplierRegistrationServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierRegistrationService implements SupplierRegistrationServiceI {
    private final SupplierRegistrationRepository supplierRegistrationRepository;
    private final SupplierRegistrationMapper supplierRegistrationMapper;

    public SupplierRegistrationService(SupplierRegistrationRepository supplierRegistrationRepository, SupplierRegistrationMapper supplierRegistrationMapper) {
        this.supplierRegistrationRepository = supplierRegistrationRepository;
        this.supplierRegistrationMapper = supplierRegistrationMapper;
    }

    @Override
    public SupplierRegistrationDto addSupplierEntity(SupplierRegistrationDto supplierRegistrationDto) {
        try{
            SupplierRegistrationEntity supplierRegistrationEntity=supplierRegistrationMapper.toSupplierRegistrationEntity(supplierRegistrationDto);
            SupplierRegistrationEntity savedEntity= supplierRegistrationRepository.save(supplierRegistrationEntity);

            return supplierRegistrationMapper.toSupplierRegistrationDto(savedEntity);
        }
        catch (Exception e){
            throw new AppException("Request failed with error" +e, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<SupplierRegistrationDto> getSupplierEntity() {
        try{
            List<SupplierRegistrationEntity> supplierEntityList=supplierRegistrationRepository.findAll();

            return supplierRegistrationMapper.toSupplierRegistrationDtoList(supplierEntityList);
        }
        catch (Exception e){
            throw new AppException("Request failed with error" +e, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public SupplierRegistrationDto updateSupplierEntity(long supplierId, SupplierRegistrationDto supplierRegistrationDto) {
        try{
            Optional<SupplierRegistrationEntity> optionalEntity=supplierRegistrationRepository.findById(supplierId);

            if(!optionalEntity.isPresent()){
                throw new AppException("Item does not exist", HttpStatus.BAD_REQUEST);
            }

            SupplierRegistrationEntity newEntity = supplierRegistrationMapper.toSupplierRegistrationEntity(supplierRegistrationDto);
            newEntity.setSupplierId(supplierId);

            SupplierRegistrationEntity updatedEntity=supplierRegistrationRepository.save(newEntity);
            return supplierRegistrationMapper.toSupplierRegistrationDto(updatedEntity);
        }
        catch (Exception e){
            throw new AppException("Request failed with error" +e, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public SupplierRegistrationDto deleteSupplier(long supplierId) {
        try{
            Optional<SupplierRegistrationEntity> optionalEntity=supplierRegistrationRepository.findById(supplierId);
            if(!optionalEntity.isPresent()) {
                throw new AppException("Customer does not exist", HttpStatus.BAD_REQUEST);
            }

            supplierRegistrationRepository.deleteById(supplierId);
            return supplierRegistrationMapper.toSupplierRegistrationDto(optionalEntity.get());
        }
        catch (Exception e){
            throw new AppException("Request failed with error" +e, HttpStatus.BAD_REQUEST);
        }
    }
}
