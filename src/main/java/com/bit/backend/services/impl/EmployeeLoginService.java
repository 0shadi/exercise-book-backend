package com.bit.backend.services.impl;

import com.bit.backend.dtos.EmployeeLoginDto;
import com.bit.backend.entities.EmployeeLoginEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.EmployeeLoginMapper;
import com.bit.backend.repositories.EmployeeLoginRepository;
import com.bit.backend.services.EmployeeLoginServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeLoginService implements EmployeeLoginServiceI {
    private final EmployeeLoginMapper employeeLoginMapper;
    private final EmployeeLoginRepository employeeLoginRepository;

    public EmployeeLoginService(EmployeeLoginMapper employeeLoginMapper, EmployeeLoginRepository employeeLoginRepository) {
        this.employeeLoginMapper = employeeLoginMapper;
        this.employeeLoginRepository = employeeLoginRepository;
    }

    @Override
    public EmployeeLoginDto addEmployeeLoginEntity(EmployeeLoginDto employeeLoginDto) {
        try{
            EmployeeLoginEntity employeeLoginEntity =employeeLoginMapper.toEmployeeLoginEntity(employeeLoginDto);
            EmployeeLoginEntity savedEntity=employeeLoginRepository.save(employeeLoginEntity);
            EmployeeLoginDto savedDto = employeeLoginMapper.toEmployeeLoginDto(savedEntity);

            return savedDto;
        }catch(Exception e){
            throw new AppException("Request failed with error" +e, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<EmployeeLoginDto> getEmployeeLoginEntity() {
        try{
            List<EmployeeLoginEntity>  employeeLoginEntityList=employeeLoginRepository.findAll();
            List<EmployeeLoginDto> employeeLoginDtoList=employeeLoginMapper.toEmployeeLoginDtoList(employeeLoginEntityList);

            return employeeLoginDtoList;
        }catch (Exception e){
            throw new AppException("Request failed with error" +e, HttpStatus.BAD_REQUEST);
        }
    }
}
