package com.bit.backend.repositories;

import com.bit.backend.entities.FormDemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

//For DB operations
public interface FormDemoRepository extends JpaRepository<FormDemoEntity,Long>{
}
//Extends already existing JpaRepository. Specify the Entity class and tha data type of the unique id