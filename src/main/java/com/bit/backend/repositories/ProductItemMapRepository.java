package com.bit.backend.repositories;

import com.bit.backend.entities.ProductItemsMapEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductItemMapRepository extends JpaRepository<ProductItemsMapEntity, Long> {
    List<ProductItemsMapEntity> findByProductAndIdNot(long productId, long id);

    List<ProductItemsMapEntity> findByProduct(long productId);
}
