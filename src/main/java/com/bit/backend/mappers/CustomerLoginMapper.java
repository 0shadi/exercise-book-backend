package com.bit.backend.mappers;

import com.bit.backend.dtos.CustomerLoginDto;
import com.bit.backend.entities.CustomerLoginEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface CustomerLoginMapper  {
    CustomerLoginDto toCustomerLoginDto(CustomerLoginEntity customerLoginEntity);
    CustomerLoginEntity toCustomerLoginEntity(CustomerLoginDto customerLoginDto);

    List<CustomerLoginDto> toCustomerLoginDtoList(List<CustomerLoginEntity> customerLoginEntityList);
}
