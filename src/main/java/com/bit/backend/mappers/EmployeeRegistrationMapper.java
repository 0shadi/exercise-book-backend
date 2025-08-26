package com.bit.backend.mappers;

import com.bit.backend.dtos.EmployeeRegistrationDto;
import com.bit.backend.entities.EmployeeRegistrationEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface EmployeeRegistrationMapper {
    EmployeeRegistrationDto toEmployeeRegistrationDto(EmployeeRegistrationEntity employeeRegistrationEntity);
    EmployeeRegistrationEntity toEmployeeRegistrationEntity(EmployeeRegistrationDto employeeRegistrationDto);

    List<EmployeeRegistrationDto> toEmployeeRegistrationDtoList(List<EmployeeRegistrationEntity> employeeEntityList);
}

