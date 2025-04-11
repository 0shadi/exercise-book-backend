package com.bit.backend.services;

import com.bit.backend.dtos.ItemTypeDto;
import com.bit.backend.dtos.SellingItemRegistrationDto;

import java.util.List;

public interface SellingItemRegistrationServiceI {
    SellingItemRegistrationDto addSellingItemEntity(SellingItemRegistrationDto sellingItemDto);

    List<SellingItemRegistrationDto> getSellingItemEntity();

    SellingItemRegistrationDto updateSellingItemEntity(SellingItemRegistrationDto sellingItemRegistrationDto, long itemId);

    SellingItemRegistrationDto deleteSellingItemEntity(long itemId);

    List<ItemTypeDto> getItemType();
}
