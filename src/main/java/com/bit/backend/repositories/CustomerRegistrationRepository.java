package com.bit.backend.repositories;

import com.bit.backend.entities.CustomerRegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRegistrationRepository extends JpaRepository<CustomerRegistrationEntity,Long> {
}
