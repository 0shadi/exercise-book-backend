package com.bit.backend.repositories;

import com.bit.backend.entities.EmployeeRegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRegistrationRepository extends JpaRepository<EmployeeRegistrationEntity,Long> {
}
