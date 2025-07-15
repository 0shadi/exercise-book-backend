package com.bit.backend.services.impl;

import com.bit.backend.dtos.ProductItemsMapDto;
import com.bit.backend.entities.ProductItemsMapEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.ProdItemsMapMapper;
import com.bit.backend.repositories.ProductItemMapRepository;
import com.bit.backend.repositories.ProductItemsRepository;
import com.bit.backend.services.ProductItemsMapServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductItemMapService implements ProductItemsMapServiceI {

    private ProductItemsRepository productItemsRepository;
    private ProductItemMapRepository productItemMapRepository;
    private ProdItemsMapMapper prodItemsMapMapper;

    public ProductItemMapService(ProductItemsRepository productItemsRepository, ProductItemMapRepository productItemMapRepository, ProdItemsMapMapper prodItemsMapMapper) {
        this.productItemsRepository = productItemsRepository;
        this.productItemMapRepository = productItemMapRepository;
        this.prodItemsMapMapper = prodItemsMapMapper;
    }

    @Override
    public ProductItemsMapDto addProductItemMap(ProductItemsMapDto productItemsMapDto) {
        try {
            ProductItemsMapEntity productItemsMapEntity = prodItemsMapMapper.toProductItemsMapEntityEntity(productItemsMapDto);
            ProductItemsMapEntity savedProduct = productItemMapRepository.save(productItemsMapEntity);
            return prodItemsMapMapper.toProdItemsMapDto(savedProduct);
        } catch (Exception e) {
            throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<ProductItemsMapDto> getData() {
        try {
            List<ProductItemsMapEntity> productItemsMapEntityList = productItemMapRepository.findAll();
            return prodItemsMapMapper.toProductItemsMapDtoList(productItemsMapEntityList);
        } catch (Exception e) {
            throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ProductItemsMapDto updateProductItemMap(long id, ProductItemsMapDto productItemsMapDto) {
        try {
            Optional<ProductItemsMapEntity> optionalProductItemsMapEntity = productItemMapRepository.findById(id);

            if (!optionalProductItemsMapEntity.isPresent()) {
                throw new AppException("Product Items Map not found", HttpStatus.BAD_REQUEST);
            }

            ProductItemsMapEntity productItemsMapEntity = prodItemsMapMapper.toProductItemsMapEntityEntity(productItemsMapDto);
            productItemsMapEntity.setId(id);
            ProductItemsMapEntity savedEntity = productItemMapRepository.save(productItemsMapEntity);
            ProductItemsMapDto savedDto = prodItemsMapMapper.toProdItemsMapDto(savedEntity);
            return savedDto;

        } catch (Exception e) {
            throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
