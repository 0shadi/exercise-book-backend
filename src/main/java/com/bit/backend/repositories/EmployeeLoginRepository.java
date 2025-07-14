package com.bit.backend.repositories;

import com.bit.backend.entities.EmployeeLoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeLoginRepository extends JpaRepository<EmployeeLoginEntity,Long> {
    Optional<List<EmployeeLoginEntity>> findByEmployee(Long employee);
}
