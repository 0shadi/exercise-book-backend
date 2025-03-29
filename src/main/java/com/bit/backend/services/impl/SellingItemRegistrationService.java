package com.bit.backend.services.impl;

import com.bit.backend.dtos.SellingItemRegistrationDto;
import com.bit.backend.entities.ItemRegistrationEntity;
import com.bit.backend.entities.SellingItemRegistrationEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.SellingItemRegistrationMapper;
import com.bit.backend.repositories.SellingItemRegistrationRepository;
import com.bit.backend.services.SellingItemRegistrationServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SellingItemRegistrationService implements SellingItemRegistrationServiceI {
    private final SellingItemRegistrationMapper sellingItemRegistrationMapper;
    private final SellingItemRegistrationRepository sellingItemRegistrationRepository;


    public SellingItemRegistrationService(SellingItemRegistrationMapper sellingItemRegistrationMapper, SellingItemRegistrationRepository sellingItemRegistrationRepository) {
        this.sellingItemRegistrationMapper = sellingItemRegistrationMapper;
        this.sellingItemRegistrationRepository = sellingItemRegistrationRepository;
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
        try{
            Optional<SellingItemRegistrationEntity> optionalEntity=sellingItemRegistrationRepository.findById(itemId);

            if(!optionalEntity.isPresent()){
                throw new AppException("Item does not exist", HttpStatus.BAD_REQUEST);
            }

            sellingItemRegistrationRepository.deleteById(itemId);
            SellingItemRegistrationEntity itemEntity=optionalEntity.get();
            return sellingItemRegistrationMapper.toSellingItemRegistrationDto(itemEntity);
        }
        catch (Exception e){
            throw new AppException("Request failed with error" +e, HttpStatus.BAD_REQUEST);
        }
    }
}
