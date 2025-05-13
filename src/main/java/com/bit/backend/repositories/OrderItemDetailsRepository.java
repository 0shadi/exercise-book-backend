package com.bit.backend.repositories;

import com.bit.backend.entities.OrderItemDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderItemDetailsRepository extends JpaRepository<OrderItemDetailsEntity,Long> {
    Optional<List<OrderItemDetailsEntity>> findByOrderId(long orderId);
}
