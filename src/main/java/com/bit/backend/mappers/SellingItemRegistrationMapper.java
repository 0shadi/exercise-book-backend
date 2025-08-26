package com.bit.backend.mappers;

import com.bit.backend.dtos.SellingItemRegistrationDto;
import com.bit.backend.entities.SellingItemRegistrationEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface SellingItemRegistrationMapper {
    SellingItemRegistrationDto toSellingItemRegistrationDto(SellingItemRegistrationEntity sellingItemRegistrationEntity);
    SellingItemRegistrationEntity toSellingItemRegistrationEntity(SellingItemRegistrationDto sellingItemRegistrationDto);

    List<SellingItemRegistrationDto> toSellingItemDtoList(List<SellingItemRegistrationEntity> sellingItemEntityList);
}
