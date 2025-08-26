package com.bit.backend.services.impl;


import com.bit.backend.dtos.ItemTypeDto;
import com.bit.backend.dtos.SellingItemRegistrationDto;
import com.bit.backend.entities.ItemTypeEntity;
import com.bit.backend.entities.SellingItemRegistrationEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.ItemTypeMapper;
import com.bit.backend.mappers.SellingItemRegistrationMapper;
import com.bit.backend.repositories.ItemTypeRepository;
import com.bit.backend.repositories.SellingItemRegistrationRepository;
import com.bit.backend.services.SellingItemRegistrationServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class SellingItemRegistrationService implements SellingItemRegistrationServiceI {
    private final SellingItemRegistrationMapper sellingItemRegistrationMapper;
    private final SellingItemRegistrationRepository sellingItemRegistrationRepository;
    private final ItemTypeMapper itemTypeMapper;
    private final ItemTypeRepository itemTypeRepository;

    public SellingItemRegistrationService(SellingItemRegistrationMapper sellingItemRegistrationMapper, SellingItemRegistrationRepository sellingItemRegistrationRepository, ItemTypeMapper itemTypeMapper, ItemTypeRepository itemTypeRepository) {
        this.sellingItemRegistrationMapper = sellingItemRegistrationMapper;
        this.sellingItemRegistrationRepository = sellingItemRegistrationRepository;
        this.itemTypeMapper = itemTypeMapper;
        this.itemTypeRepository = itemTypeRepository;
    }

    @Override
    public SellingItemRegistrationDto addSellingItemEntity(SellingItemRegistrationDto sellingItemDto) {
        try{
            SellingItemRegistrationEntity SellingItemEntity=sellingItemRegistrationMapper.toSellingItemRegistrationEntity(sellingItemDto);
            SellingItemRegistrationEntity savedEntity=sellingItemRegistrationRepository.save(SellingItemEntity);
            SellingItemRegistrationDto savedDto=sellingItemRegistrationMapper.toSellingItemRegistrationDto(savedEntity);
            return savedDto;
        }
        catch (Exception e){
            throw new AppException("Request failed with error" +e, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<SellingItemRegistrationDto> getSellingItemEntity() {
        try{
            List<SellingItemRegistrationEntity> sellingItemEntityList = sellingItemRegistrationRepository.findAll();
            List<SellingItemRegistrationDto> sellingItemDtoList=sellingItemRegistrationMapper.toSellingItemDtoList(sellingItemEntityList);

            for (SellingItemRegistrationDto dto : sellingItemDtoList) {

                if (dto.getItemImage() != null) {
                    String base64Image = Base64.getEncoder().encodeToString(dto.getItemImage());
                    dto.setImageBase64(base64Image);
                }
            }

            return sellingItemDtoList;
        }
        catch (Exception e){
            throw new AppException("Request failed with error" +e, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public SellingItemRegistrationDto updateSellingItemEntity(SellingItemRegistrationDto sellingItemRegistrationDto, long itemId) {
        try{
            Optional<SellingItemRegistrationEntity> optionalEntity=sellingItemRegistrationRepository.findById(itemId);

            if(!optionalEntity.isPresent()){
                throw new AppException("Item does not exist", HttpStatus.BAD_REQUEST);
            }

            SellingItemRegistrationEntity newEntity=sellingItemRegistrationMapper.toSellingItemRegistrationEntity(sellingItemRegistrationDto);
            newEntity.setItemId(itemId);
            SellingItemRegistrationEntity updatedEntity =sellingItemRegistrationRepository.save(newEntity);
            return sellingItemRegistrationMapper.toSellingItemRegistrationDto(updatedEntity);
        }
        catch (Exception e){
            throw new AppException("Request failed with error" +e, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public SellingItemRegistrationDto deleteSellingItemEntity(long itemId) {
        try {
            Optional<SellingItemRegistrationEntity> optionalEntity = sellingItemRegistrationRepository.findById(itemId);

            if (!optionalEntity.isPresent()) {
                throw new AppException("Item does not exist", HttpStatus.BAD_REQUEST);
            }

            sellingItemRegistrationRepository.deleteById(itemId);
            SellingItemRegistrationEntity itemEntity = optionalEntity.get();
            return sellingItemRegistrationMapper.toSellingItemRegistrationDto(itemEntity);
        } catch (Exception e) {
            throw new AppException("Request failed with error" + e, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<ItemTypeDto> getItemType() {
        try{
            List<ItemTypeEntity> itemTypeEntityList = itemTypeRepository.findAll();
            List<ItemTypeDto> itemTypeDtoList=itemTypeMapper.toItemTypeEntityList(itemTypeEntityList);

            return itemTypeDtoList;
        }
        catch (Exception e){
            throw new AppException("Request failed with error" +e, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public SellingItemRegistrationDto getSellingItem(long itemId) {
        try {
            Optional<SellingItemRegistrationEntity> optionalEntity = sellingItemRegistrationRepository.findById(itemId);

            if (!optionalEntity.isPresent()) {
                throw new AppException("Item does not exist", HttpStatus.BAD_REQUEST);
            }
            SellingItemRegistrationEntity itemEntity = optionalEntity.get();
            SellingItemRegistrationDto sellingItemRegistrationDto = sellingItemRegistrationMapper.toSellingItemRegistrationDto(itemEntity);

            if (sellingItemRegistrationDto.getItemImage() != null) {
                String base64Image = Base64.getEncoder().encodeToString(sellingItemRegistrationDto.getItemImage());
                sellingItemRegistrationDto.setImageBase64(base64Image);
            }

            return sellingItemRegistrationDto;

        } catch (Exception e) {
            throw new AppException("Request failed with error" + e, HttpStatus.BAD_REQUEST);
        }
    }


}
