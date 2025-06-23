package com.bit.backend.repositories;

import com.bit.backend.entities.CustomerLoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerLoginRepository extends JpaRepository<CustomerLoginEntity,Long> {
}
