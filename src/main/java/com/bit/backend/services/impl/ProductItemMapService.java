package com.bit.backend.services.impl;

import com.bit.backend.dtos.*;
import com.bit.backend.entities.ProductItemsMapEntity;
import com.bit.backend.entities.SellingItemRegistrationEntity;
import com.bit.backend.entities.StockEntitiy;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.ProdItemsMapMapper;
import com.bit.backend.mappers.StockMapper;
import com.bit.backend.repositories.ProductItemMapRepository;
import com.bit.backend.repositories.ProductItemsRepository;
import com.bit.backend.repositories.StockRepository;
import com.bit.backend.services.ProductItemsMapServiceI;
import com.bit.backend.services.SellingItemRegistrationServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductItemMapService implements ProductItemsMapServiceI {

    private ProductItemsRepository productItemsRepository;
    private ProductItemMapRepository productItemMapRepository;
    private ProdItemsMapMapper prodItemsMapMapper;
    private StockRepository stockRepository;
    private SellingItemRegistrationServiceI sellingItemRegistrationServiceI;
    private StockMapper stockMapper;

    public ProductItemMapService(ProductItemsRepository productItemsRepository, ProductItemMapRepository productItemMapRepository,
                                 ProdItemsMapMapper prodItemsMapMapper, StockRepository stockRepository, SellingItemRegistrationServiceI sellingItemRegistrationServiceI,
                                 StockMapper stockMapper) {
        this.productItemsRepository = productItemsRepository;
        this.productItemMapRepository = productItemMapRepository;
        this.prodItemsMapMapper = prodItemsMapMapper;
        this.stockRepository = stockRepository;
        this.sellingItemRegistrationServiceI = sellingItemRegistrationServiceI;
        this.stockMapper = stockMapper;
    }

    @Override
    public ProductItemsMapDto addProductItemMap(ProductItemsMapDto productItemsMapDto) {
        try {

            String[] stockAdjustStatus = this.adjustStock(productItemsMapDto);

            if (stockAdjustStatus.length > 0 && Integer.parseInt(stockAdjustStatus[0]) < 0) {
                throw new AppException("Stock does not have required quantity for the item " + stockAdjustStatus[1], HttpStatus.INTERNAL_SERVER_ERROR);
            }

            if (stockAdjustStatus.length > 0 && Integer.parseInt(stockAdjustStatus[0]) < 0) {
                throw new AppException("Error while adjusting the stocks! Please try again", HttpStatus.INTERNAL_SERVER_ERROR);
            }

            long productId = productItemsMapDto.getProduct();

            List<ProductItemsMapEntity> productItemsMapEntityList = productItemMapRepository.findByProduct(productId);

            if (productItemsMapEntityList.size() > 0) {
                throw new AppException("Value already exists for the provided product", HttpStatus.INTERNAL_SERVER_ERROR);
            }

            ProductItemsMapEntity productItemsMapEntity = prodItemsMapMapper.toProductItemsMapEntityEntity(productItemsMapDto);
            ProductItemsMapEntity savedProduct = productItemMapRepository.save(productItemsMapEntity);

            SellingItemRegistrationDto sellingItemRegistrationDto = sellingItemRegistrationServiceI.getSellingItem(productItemsMapDto.getProduct());
            sellingItemRegistrationDto.setItemQuantity(Integer.toString(productItemsMapDto.getProductQuantity()));
            SellingItemRegistrationDto sellingItemDto = sellingItemRegistrationServiceI.updateSellingItemEntity(sellingItemRegistrationDto, productItemsMapDto.getProduct());

            return prodItemsMapMapper.toProdItemsMapDto(savedProduct);
        } catch (Exception e) {
            throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public String[] adjustStock(ProductItemsMapDto productItemsMapDto) {
        try {
            int productQty = productItemsMapDto.getProductQuantity();
            List<ProductItemsDto> productItemsDtoList = productItemsMapDto.getItemList();

            for(ProductItemsDto productItemsDto: productItemsDtoList) {
                int usedQty = productItemsDto.getItemQuantity().intValue() * productQty;
                StockEntitiy stockEntitiy = stockRepository.findByItemID(productItemsDto.getItemId());
                int availableQty = stockEntitiy.getQty();
                int remainingQty = availableQty - usedQty;

                if (remainingQty < 0) {
                    String[] status = {"-1", productItemsDto.getItemName()};
                    return status;
                }

                StockEntitiy newStockEntitiy = stockEntitiy;
                newStockEntitiy.setQty(remainingQty);
                StockDTO stockDTO = stockMapper.toStockDto(stockRepository.save(newStockEntitiy));
            }
        } catch (Exception e) {
            String[] status = {"-2", "-2"};
            return status;
        }
        String[] status = {"1", "1"};
        return status;
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

            String[] stockAdjustStatus = this.adjustStock(productItemsMapDto);

            if (stockAdjustStatus.length > 0 && Integer.parseInt(stockAdjustStatus[0]) < 0) {
                throw new AppException("Stock does not have required quantity for the item " + stockAdjustStatus[1], HttpStatus.INTERNAL_SERVER_ERROR);
            }

            if (stockAdjustStatus.length > 0 && Integer.parseInt(stockAdjustStatus[0]) < 0) {
                throw new AppException("Error while adjusting the stocks! Please try again", HttpStatus.INTERNAL_SERVER_ERROR);
            }

            long productId = productItemsMapDto.getProduct();

            List<ProductItemsMapEntity> productItemsMapEntityList = productItemMapRepository.findByProductAndIdNot(productId, id);

            if (productItemsMapEntityList.size() > 0) {
                throw new AppException("Product can't update to a already existing product", HttpStatus.INTERNAL_SERVER_ERROR);
            }

            ProductItemsMapEntity productItemsMapEntity = prodItemsMapMapper.toProductItemsMapEntityEntity(productItemsMapDto);
            productItemsMapEntity.setId(id);
            ProductItemsMapEntity savedEntity = productItemMapRepository.save(productItemsMapEntity);

            SellingItemRegistrationDto sellingItemRegistrationDto = sellingItemRegistrationServiceI.getSellingItem(productItemsMapDto.getProduct());
            sellingItemRegistrationDto.setItemQuantity(Integer.toString(productItemsMapDto.getProductQuantity() + Integer.parseInt(sellingItemRegistrationDto.getItemQuantity())) );
            SellingItemRegistrationDto sellingItemDto = sellingItemRegistrationServiceI.updateSellingItemEntity(sellingItemRegistrationDto, productItemsMapDto.getProduct());

            ProductItemsMapDto savedDto = prodItemsMapMapper.toProdItemsMapDto(savedEntity);
            return savedDto;

        } catch (Exception e) {
            throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
