package com.bit.backend.repositories;

import com.bit.backend.entities.ItemTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemTypeRepository extends JpaRepository<ItemTypeEntity,Long> {
}
