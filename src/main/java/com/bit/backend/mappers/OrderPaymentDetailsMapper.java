package com.bit.backend.mappers;

import com.bit.backend.dtos.OrderPaymentDetailsDto;
import com.bit.backend.entities.OrderPaymentDetailsEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface OrderPaymentDetailsMapper {
    OrderPaymentDetailsDto toOrderPaymentDetailsDto(OrderPaymentDetailsEntity orderPaymentDetailsEntity);
    OrderPaymentDetailsEntity toOrderPaymentDetailsEntity(OrderPaymentDetailsDto orderPaymentDetailsDto);
}
