package com.bit.backend.services.impl;

import com.bit.backend.dtos.FormDemoDto;
import com.bit.backend.entities.FormDemoEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.FormDemoMapper;
import com.bit.backend.repositories.FormDemoRepository;
import com.bit.backend.services.FormDemoServicei;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Why create an implementation class without writing the function in the service class?
@Service
public class FormDemoService implements FormDemoServicei {

    //Creating objects
    private final FormDemoRepository formDemoRepository;
    private final FormDemoMapper formDemoMapper;

    //Creating constructor
    public FormDemoService(FormDemoRepository formDemoRepository, FormDemoMapper formDemoMapper) {
        this.formDemoRepository = formDemoRepository;
        this.formDemoMapper = formDemoMapper;
    }

    @Override
    public FormDemoDto addFormDemoEntity(FormDemoDto formDemoDto) {
        try{
            System.out.println("In backend");

            //Converting the DTO from the mapper to Entity (To save it in the database)
            FormDemoEntity formDemoEntity = formDemoMapper.toFormDemoEntity(formDemoDto);
            //Save the Entity in the database using the repository
            FormDemoEntity savedItem = formDemoRepository.save(formDemoEntity);
            //Converting the Entity back into DTO because we want to return the saveditem
            FormDemoDto savedDto = formDemoMapper.toFormDemoDto(savedItem);

            return savedDto;
        }catch (Exception e){
            throw new AppException("Request failed with error: "+e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<FormDemoDto> getData() {
        try {
            List<FormDemoEntity> formDemoEntityList = formDemoRepository.findAll();

            List<FormDemoDto> formDemoDtoList = formDemoMapper.toFormDemoDtoList(formDemoEntityList);
            return formDemoDtoList;
        }catch (Exception e){
            throw new AppException("Request failed with error: "+e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public FormDemoDto updateForm(long id, FormDemoDto formDemoDto) {
        try {
            Optional<FormDemoEntity> formDemoEntityOptional = formDemoRepository.findById(id);

            //Checking if the id is available
            if (!formDemoEntityOptional.isPresent()) {
                throw new AppException("Form Demo DOEs not Exists", HttpStatus.BAD_REQUEST);
            }

            //Converting Dto to Entity
            FormDemoEntity newFormDemoEntity = formDemoMapper.toFormDemoEntity(formDemoDto);
            //Set the id
            newFormDemoEntity.setId(id);
            //Saving the Entity to repository
            FormDemoEntity formDemoEntity=formDemoRepository.save(newFormDemoEntity);
            //Converting the Entity to Dto
            FormDemoDto responseFormDemoDTO = formDemoMapper.toFormDemoDto(formDemoEntity);
            return responseFormDemoDTO;
        }catch (Exception e){
            throw new AppException("Request failed with error: "+e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public FormDemoDto deleteFormDemo(long id) {
        try {
            Optional<FormDemoEntity> formDemoEntityOptional = formDemoRepository.findById(id);

            //Check if the Entity is available
            if (!formDemoEntityOptional.isPresent()) {
                throw new AppException("Form Demo DOEs not Exists", HttpStatus.BAD_REQUEST);
            }

            //Send the id to the delete function in repository
            formDemoRepository.deleteById(id);

            return formDemoMapper.toFormDemoDto(formDemoEntityOptional.get());
        }catch (Exception e){
            throw new AppException("Request failed with error: "+e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
