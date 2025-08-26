package com.bit.backend.services;

import com.bit.backend.dtos.ProductItemsMapDto;

import java.util.List;

public interface ProductItemsMapServiceI {
    ProductItemsMapDto addProductItemMap(ProductItemsMapDto productItemsMapDto);
    List<ProductItemsMapDto> getData();
    ProductItemsMapDto updateProductItemMap(long id, ProductItemsMapDto productItemsMapDto);
}
