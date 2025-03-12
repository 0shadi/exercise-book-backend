package com.bit.backend.services;

import com.bit.backend.dtos.SupplierRegistrationDto;

import java.util.List;

public interface SupplierRegistrationServiceI {
    SupplierRegistrationDto addSupplierEntity(SupplierRegistrationDto supplierRegistrationDto);

    List<SupplierRegistrationDto> getSupplierEntity();
}
