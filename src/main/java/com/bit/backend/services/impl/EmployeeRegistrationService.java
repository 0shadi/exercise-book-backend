package com.bit.backend.services.impl;

import com.bit.backend.dtos.EmployeeRegistrationDto;
import com.bit.backend.entities.EmployeeRegistrationEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.EmployeeRegistrationMapper;
import com.bit.backend.repositories.EmployeeRegistrationRepository;
import com.bit.backend.services.EmployeeRegistrationI;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeRegistrationService implements EmployeeRegistrationI {
    private final EmployeeRegistrationMapper employeeRegistrationMapper;
    private final EmployeeRegistrationRepository employeeRegistrationRepository;

    public EmployeeRegistrationService(EmployeeRegistrationMapper employeeRegistrationMapper, EmployeeRegistrationRepository employeeRegistrationRepository) {
        this.employeeRegistrationMapper = employeeRegistrationMapper;
        this.employeeRegistrationRepository = employeeRegistrationRepository;
    }

    @Override
    public EmployeeRegistrationDto addEmployeeRegistrationEntity(EmployeeRegistrationDto employeeRegistrationDto){
        try{
            EmployeeRegistrationEntity employeeRegistrationEntity =employeeRegistrationMapper.toEmployeeRegistrationEntity(employeeRegistrationDto);
            EmployeeRegistrationEntity savedEntity=employeeRegistrationRepository.save(employeeRegistrationEntity);
            EmployeeRegistrationDto savedDto = employeeRegistrationMapper.toEmployeeRegistrationDto(savedEntity);

            return savedDto;
        }catch(Exception e){
            throw new AppException("Request failed with error" +e, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<EmployeeRegistrationDto> getEmployeeEntity() {
        try{
            List<EmployeeRegistrationEntity>  employeeEntityList=employeeRegistrationRepository.findAll();
            List<EmployeeRegistrationDto> employeeDtoList=employeeRegistrationMapper.toEmployeeRegistrationDtoList(employeeEntityList);

            return employeeDtoList;
        }catch (Exception e){
            throw new AppException("Request failed with error" +e, HttpStatus.BAD_REQUEST);
        }
    }   

    @Override
    public EmployeeRegistrationDto updateEmployee(long employeeNumber, EmployeeRegistrationDto employeeRegistrationDto) {
        try{
            Optional<EmployeeRegistrationEntity> OptionalEmployeeEntity=employeeRegistrationRepository.findById(employeeNumber);

            if(!OptionalEmployeeEntity.isPresent()){
                throw new AppException("Employee does not exist", HttpStatus.BAD_REQUEST);
            }

            EmployeeRegistrationEntity newEmployeeEntity=employeeRegistrationMapper.toEmployeeRegistrationEntity(employeeRegistrationDto);
            newEmployeeEntity.setEmployeeNumber(employeeNumber);//To set the employeeNumber of the newEntity
            EmployeeRegistrationEntity savedEntity=employeeRegistrationRepository.save(newEmployeeEntity);
            EmployeeRegistrationDto updatedDto=employeeRegistrationMapper.toEmployeeRegistrationDto(savedEntity);

            return updatedDto;
        }catch (Exception e){
            throw new AppException("Request failed with error" +e, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public EmployeeRegistrationDto deleteEmployee(long employeeNumber) {
        try{
            Optional<EmployeeRegistrationEntity> OptionalEmployeeEntity=employeeRegistrationRepository.findById(employeeNumber);

            if(!OptionalEmployeeEntity.isPresent()){
                throw new AppException("Employee does not exist", HttpStatus.BAD_REQUEST);
            }

            employeeRegistrationRepository.deleteById(employeeNumber);


            return employeeRegistrationMapper.toEmployeeRegistrationDto(OptionalEmployeeEntity.get());
        }
        catch (Exception e){
            throw new AppException("Request failed with error" +e, HttpStatus.BAD_REQUEST);
        }
    }
}
