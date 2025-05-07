package com.bit.backend.repositories;

import com.bit.backend.entities.OrderItemDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemDetailsRepository extends JpaRepository<OrderItemDetailsEntity,Long> {
}
