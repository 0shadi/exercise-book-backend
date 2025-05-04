package com.bit.backend.mappers;

import com.bit.backend.dtos.OrderDetailsDto;
import com.bit.backend.entities.OrderDetailsEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface OrderDetailsMapper {
    OrderDetailsDto toOrderDetailsDto(OrderDetailsEntity orderDetailsEntity);
    OrderDetailsEntity toOrderDetailsEntity(OrderDetailsDto orderDetailsDto);
}
