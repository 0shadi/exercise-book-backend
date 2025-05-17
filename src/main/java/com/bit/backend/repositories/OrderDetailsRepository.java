package com.bit.backend.repositories;

import com.bit.backend.entities.OrderDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderDetailsRepository extends JpaRepository<OrderDetailsEntity,Long> {
    Optional<OrderDetailsEntity> findByOrderId(long orderId);
}
