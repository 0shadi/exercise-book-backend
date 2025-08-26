package com.bit.backend.mappers;

import com.bit.backend.dtos.CustomizedBillingDetailsDto;
import com.bit.backend.entities.CustomizedBillingDetailsEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface CustomizedBillingDetailsMapper {
    CustomizedBillingDetailsDto toCustomizedBillingDetailsDto(CustomizedBillingDetailsEntity customizedBillingDetailsEntity);
    CustomizedBillingDetailsEntity toCustomizedBillingDetailsEntity(CustomizedBillingDetailsDto customizedBillingDetailsDto);
}
