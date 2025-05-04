package com.bit.backend.repositories;

import com.bit.backend.entities.OrderDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<OrderDetailsEntity,Long> {
}
