package com.bit.backend.repositories;

import com.bit.backend.entities.CustomizedOrderDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomizedOrderDetailsRepository extends JpaRepository<CustomizedOrderDetailsEntity,Long> {
}
