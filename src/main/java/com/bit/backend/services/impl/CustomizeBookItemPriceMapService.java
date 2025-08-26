package com.bit.backend.services.impl;

import com.bit.backend.dtos.CustomizeBookItemPriceMapDto;
import com.bit.backend.entities.CustomizeBookItemPriceMapEntity;
import com.bit.backend.mappers.CustomizeBookItemPriceMapMapper;
import com.bit.backend.repositories.CustomizeBookItemPriceMapRepository;
import com.bit.backend.services.CustomizeBookItemPriceMapI;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomizeBookItemPriceMapService implements CustomizeBookItemPriceMapI {

    private final CustomizeBookItemPriceMapRepository customizeBookItemPriceMapRepository;
    private final CustomizeBookItemPriceMapMapper customizeBookItemPriceMapMapper;

    public CustomizeBookItemPriceMapService(CustomizeBookItemPriceMapMapper customizeBookItemPriceMapMapper, CustomizeBookItemPriceMapRepository customizeBookItemPriceMapRepository) {
        this.customizeBookItemPriceMapMapper = customizeBookItemPriceMapMapper;
        this.customizeBookItemPriceMapRepository = customizeBookItemPriceMapRepository;
    }

    @Override
    public List<CustomizeBookItemPriceMapDto> getData() {
        List<CustomizeBookItemPriceMapEntity> customizeBookItemPriceMapEntityList = customizeBookItemPriceMapRepository.findAll();
        List<CustomizeBookItemPriceMapDto> customizeBookItemPriceMapDtos = customizeBookItemPriceMapMapper.toCustomizeBookItemPriceMapDtoList(customizeBookItemPriceMapEntityList);
        return customizeBookItemPriceMapDtos;
    }
}
