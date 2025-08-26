package com.bit.backend.mappers;

import com.bit.backend.dtos.CustomizedBookDetailsDto;
import com.bit.backend.entities.CustomizedBookDetailsEntity;
import com.bit.backend.entities.CustomizedOrderDetailsEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface CustomizedBookDetailsMapper {
    CustomizedBookDetailsDto toCustomizedBookDetailsDto(CustomizedBookDetailsEntity customizedBookDetailsEntity);
    CustomizedBookDetailsEntity toCustomizedBookDetailsEntity(CustomizedBookDetailsDto customizedBookDetailsDto);

    List<CustomizedBookDetailsDto> toCustomizedBookDetailsDtoList(List<CustomizedBookDetailsEntity> itemEntity);
}
