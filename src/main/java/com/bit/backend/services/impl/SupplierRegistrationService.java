package com.bit.backend.services.impl;

import com.bit.backend.dtos.SupplierRegistrationDto;
import com.bit.backend.entities.SupplierRegistrationEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.SupplierRegistrationMapper;
import com.bit.backend.repositories.SupplierRegistrationRepository;
import com.bit.backend.services.SupplierRegistrationServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
