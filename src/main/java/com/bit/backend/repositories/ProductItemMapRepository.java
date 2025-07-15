package com.bit.backend.repositories;

import com.bit.backend.entities.ProductItemsMapEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductItemMapRepository extends JpaRepository<ProductItemsMapEntity, Long> {
}
