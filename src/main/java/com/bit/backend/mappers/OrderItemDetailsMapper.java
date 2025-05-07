package com.bit.backend.mappers;

import com.bit.backend.dtos.OrderItemDetailsDto;
import com.bit.backend.entities.OrderItemDetailsEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface OrderItemDetailsMapper {
    OrderItemDetailsDto toOrderItemDetailsDto(OrderItemDetailsEntity orderItemDetailsEntity);
    OrderItemDetailsEntity toOrderItemDetailsEntity(OrderItemDetailsDto orderItemDetailsDto);
}
