package com.bit.backend.services.impl;

import com.bit.backend.dtos.ItemRegistrationDto;
import com.bit.backend.entities.ItemRegistrationEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.ItemRegistrationMapper;
import com.bit.backend.repositories.ItemRegistrationRepository;
import com.bit.backend.services.ItemRegistrationServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemRegistrationService  implements ItemRegistrationServiceI {
    private final ItemRegistrationRepository itemRegistrationRepository;
    private final ItemRegistrationMapper itemRegistrationMapper;

    public ItemRegistrationService(ItemRegistrationMapper itemRegistrationMapper, ItemRegistrationRepository itemRegistrationRepository) {
        this.itemRegistrationMapper = itemRegistrationMapper;
        this.itemRegistrationRepository = itemRegistrationRepository;
    }

    @Override
    public ItemRegistrationDto addItemEntity(ItemRegistrationDto itemRegistrationDto) {
        try{
            ItemRegistrationEntity itemEntity=itemRegistrationMapper.toItemRegistrationEntity(itemRegistrationDto);
            ItemRegistrationEntity savedEntity=itemRegistrationRepository.save(itemEntity);
            ItemRegistrationDto savedDto=itemRegistrationMapper.toItemRegistrationDto(savedEntity);
            return savedDto;
        }
        catch (Exception e){
            throw new AppException("Request failed with error" +e, HttpStatus.BAD_REQUEST);
    }}

    @Override
    public List<ItemRegistrationDto> getItemEntity() {
        try{
            List<ItemRegistrationEntity> itemEntityList =itemRegistrationRepository.findAll();
            List<ItemRegistrationDto> itemDtoList=itemRegistrationMapper.toItemRegistrationDtoList(itemEntityList);
            return itemDtoList;
        }
        catch (Exception e){
            throw new AppException("Request failed with error" +e, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ItemRegistrationDto updateItemEntity(ItemRegistrationDto itemRegistrationDto, long itemId) {
        try{
            Optional<ItemRegistrationEntity> optionalEntity=itemRegistrationRepository.findById(itemId);

            if(!optionalEntity.isPresent()){
                throw new AppException("Item does not exist", HttpStatus.BAD_REQUEST);
            }

            ItemRegistrationEntity newEntity=itemRegistrationMapper.toItemRegistrationEntity(itemRegistrationDto);
            newEntity.setItemId(itemId);
            ItemRegistrationEntity updatedEntity =itemRegistrationRepository.save(newEntity);
            return itemRegistrationMapper.toItemRegistrationDto(updatedEntity);
        }
        catch (Exception e){
            throw new AppException("Request failed with error" +e, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ItemRegistrationDto deleteItemEntity(long itemId) {
        try{
            Optional<ItemRegistrationEntity> optionalEntity=itemRegistrationRepository.findById(itemId);

            if(!optionalEntity.isPresent()){
                throw new AppException("Item does not exist", HttpStatus.BAD_REQUEST);
            }

            itemRegistrationRepository.deleteById(itemId);
            ItemRegistrationEntity itemEntity=optionalEntity.get();
            return itemRegistrationMapper.toItemRegistrationDto(itemEntity);
        }
        catch (Exception e){
            throw new AppException("Request failed with error" +e, HttpStatus.BAD_REQUEST);
        }
}}
