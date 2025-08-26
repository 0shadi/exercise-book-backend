package com.bit.backend.mappers;

import com.bit.backend.dtos.BillingDetailsDto;
import com.bit.backend.entities.BillingDetailsEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface BillingDetailsMapper {
    BillingDetailsDto toToBillingDetailsDto(BillingDetailsEntity billingDetailsEntity);
    BillingDetailsEntity toBillingDetailsEntity(BillingDetailsDto billingDetailsDto);
}
