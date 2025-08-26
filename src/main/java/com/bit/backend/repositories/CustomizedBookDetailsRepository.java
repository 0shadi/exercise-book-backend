package com.bit.backend.repositories;

import com.bit.backend.entities.CustomizedBookDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomizedBookDetailsRepository extends JpaRepository<CustomizedBookDetailsEntity,Long> {
    Optional<List<CustomizedBookDetailsEntity>> findByOrderId(long orderId);
}
