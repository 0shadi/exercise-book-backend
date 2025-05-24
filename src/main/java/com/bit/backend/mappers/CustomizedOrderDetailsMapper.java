package com.bit.backend.mappers;

import com.bit.backend.dtos.CustomizedOrderDetailsDto;
import com.bit.backend.entities.CustomizedOrderDetailsEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface CustomizedOrderDetailsMapper {
    CustomizedOrderDetailsEntity toCustomizedOrderDetailsEntity(CustomizedOrderDetailsDto customizedOrderDetailsDto);
    CustomizedOrderDetailsDto toCustomizedOrderDetailsDto(CustomizedOrderDetailsEntity customizedOrderDetailsEntity);
}
