package com.bit.backend.repositories;

import com.bit.backend.entities.CustomerLoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerLoginRepository extends JpaRepository<CustomerLoginEntity,Long> {
    Optional<List<CustomerLoginEntity>> findByCustomerId(Long customerId);
}
