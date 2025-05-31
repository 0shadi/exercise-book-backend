package com.bit.backend.repositories;

import com.bit.backend.entities.CustomizedOrderDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomizedOrderDetailsRepository extends JpaRepository<CustomizedOrderDetailsEntity,Long> {
    Optional<CustomizedOrderDetailsEntity> findByOrderId(long orderId);
}
