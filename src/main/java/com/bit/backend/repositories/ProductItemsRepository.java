package com.bit.backend.repositories;

import com.bit.backend.entities.ProductItemsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductItemsRepository extends JpaRepository<ProductItemsEntity, Long> {
}
