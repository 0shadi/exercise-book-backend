package com.bit.backend.mappers;

import com.bit.backend.dtos.CustomerRegistrationDto;
import com.bit.backend.entities.CustomerRegistrationEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface CustomerRegistrationMapper {
    CustomerRegistrationDto toCustomerRegistrationDto(CustomerRegistrationEntity customerRegistrationEntity);
    CustomerRegistrationEntity toCustomerRegistrationEntity(CustomerRegistrationDto customerRegistrationDto);
    List<CustomerRegistrationDto> toCustomerRegistrationDtoList(List<CustomerRegistrationEntity> customerRegistrationEntityList);
}
