package com.bit.backend.mappers;

import com.bit.backend.dtos.ProductItemsDto;
import com.bit.backend.dtos.ProductItemsMapDto;
import com.bit.backend.entities.ProductItemsEntity;
import com.bit.backend.entities.ProductItemsMapEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface ProdItemsMapMapper {
    @Mapping(source = "itemList", target = "itemList")
    ProductItemsMapDto toProdItemsMapDto(ProductItemsMapEntity productItemsMapEntity);

    @Mapping(source = "itemList", target = "itemList")
    ProductItemsMapEntity toProductItemsMapEntityEntity(ProductItemsMapDto productItemsMapDto);

    ProductItemsEntity toProductItemsDto(ProductItemsDto productItemsDto);

    ProductItemsDto toProductItemsEntity(ProductItemsEntity productItemsEntity);

    List<ProductItemsEntity> toProductItemsEntityList(List<ProductItemsDto> productItemsDtoList);

    List<ProductItemsDto> toProductItemsDtoList(List<ProductItemsEntity> productItemsEntities);

    List<ProductItemsMapDto> toProductItemsMapDtoList(List<ProductItemsMapEntity> productItemsMapEntities);
}
