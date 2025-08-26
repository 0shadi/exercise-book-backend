package com.bit.backend.mappers;

import com.bit.backend.dtos.ItemRegistrationDto;
import com.bit.backend.dtos.ItemTypeDto;
import com.bit.backend.entities.ItemRegistrationEntity;
import com.bit.backend.entities.ItemTypeEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface ItemTypeMapper {
    ItemTypeDto toItemTypeDto(ItemTypeEntity itemTypeEntity);
    ItemTypeEntity toItemTypeEntity(ItemTypeDto itemTypeDto);

    List<ItemTypeDto> toItemTypeEntityList(List<ItemTypeEntity> itemTypeEntityList);
}
