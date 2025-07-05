package com.bit.backend.mappers;

import com.bit.backend.dtos.CustomizationPaymentDetailsDto;
import com.bit.backend.entities.CustomizationPaymentDetailsEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface CustomizationPaymentDetailsMapper {
    CustomizationPaymentDetailsDto toCustomizationPaymentDetailsDto(CustomizationPaymentDetailsEntity customizationPaymentDetailsEntity);
    CustomizationPaymentDetailsEntity toCustomizationPaymentDetailsEntity(CustomizationPaymentDetailsDto customizationPaymentDetailsDto);
}
