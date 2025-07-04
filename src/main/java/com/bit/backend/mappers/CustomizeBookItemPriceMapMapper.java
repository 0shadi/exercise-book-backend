package com.bit.backend.mappers;

import com.bit.backend.dtos.CustomizeBookItemPriceMapDto;
import com.bit.backend.entities.CustomizeBookItemPriceMapEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface CustomizeBookItemPriceMapMapper {

    CustomizeBookItemPriceMapDto toCustomizeBookItemPriceMapDto(CustomizeBookItemPriceMapEntity customizeBookItemPriceMapEntity);
    CustomizeBookItemPriceMapEntity toCustomizeBookItemPriceMapEntity(CustomizeBookItemPriceMapDto customizeBookItemPriceMapDto);
    List<CustomizeBookItemPriceMapDto> toCustomizeBookItemPriceMapDtoList(List<CustomizeBookItemPriceMapEntity> customizeBookItemPriceMapEntityList);
}
