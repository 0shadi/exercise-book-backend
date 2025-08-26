package com.bit.backend.repositories;

import com.bit.backend.entities.OrderPaymentDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderPaymentDetailsRepository extends JpaRepository<OrderPaymentDetailsEntity,Long> {
}
