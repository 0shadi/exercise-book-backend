package com.bit.backend.repositories;

import com.bit.backend.entities.BillingDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingDetailsRepository extends JpaRepository<BillingDetailsEntity,Long> {
}
