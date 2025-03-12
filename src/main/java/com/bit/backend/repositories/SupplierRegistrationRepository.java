package com.bit.backend.repositories;

import com.bit.backend.entities.SupplierRegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRegistrationRepository extends JpaRepository<SupplierRegistrationEntity,Long> {
}
