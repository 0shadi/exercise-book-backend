package com.bit.backend.services;

import com.bit.backend.dtos.ItemRegistrationDto;

import java.util.List;

public interface ItemRegistrationServiceI {
   ItemRegistrationDto  addItemEntity(ItemRegistrationDto itemRegistrationDto);

    List<ItemRegistrationDto> getItemEntity();

    ItemRegistrationDto updateItemEntity(ItemRegistrationDto itemRegistrationDto, long itemId);

    ItemRegistrationDto deleteItemEntity(long itemId);
}
