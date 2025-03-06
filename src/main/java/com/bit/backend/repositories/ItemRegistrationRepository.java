package com.bit.backend.repositories;

import com.bit.backend.entities.ItemRegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRegistrationRepository extends JpaRepository<ItemRegistrationEntity,Long> {

}
