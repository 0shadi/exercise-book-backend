package com.bit.backend.repositories;

import com.bit.backend.entities.CustomizationPaymentDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomizationPaymentDetailsRepository extends JpaRepository<CustomizationPaymentDetailsEntity,Long> {
}
