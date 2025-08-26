package com.bit.backend.mappers;

import com.bit.backend.dtos.ItemRegistrationDto;
import com.bit.backend.entities.ItemRegistrationEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface ItemRegistrationMapper {
     ItemRegistrationDto toItemRegistrationDto(ItemRegistrationEntity itemRegistrationEntity);
     ItemRegistrationEntity toItemRegistrationEntity(ItemRegistrationDto itemRegistrationDto);

    List<ItemRegistrationDto> toItemRegistrationDtoList(List<ItemRegistrationEntity> itemEntityList);
}
