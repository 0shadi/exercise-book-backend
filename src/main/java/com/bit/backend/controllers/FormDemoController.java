package com.bit.backend.controllers;

import com.bit.backend.dtos.FormDemoDto;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.FormDemoServicei;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class FormDemoController {

    //Create an object of the FormDemoService interface
    private final FormDemoServicei formDemoService;

    //FormController class constructor
    public FormDemoController(FormDemoServicei formDemoService) {
        this.formDemoService = formDemoService;
    }

    //Catch the variables sent by the post mapping from the front end and send it to the service
    @PostMapping("/form-demo")
    public ResponseEntity<FormDemoDto> addForm(@RequestBody FormDemoDto formDemoDto) {
        try{
            //Pass DTO to the service and it will convert the DTO to Entity and then save it in the repository and return the saved DTO here
            FormDemoDto FormDemoDtoResponse = formDemoService.addFormDemoEntity(formDemoDto);
            return ResponseEntity.created(URI.create("/form-demo" + FormDemoDtoResponse.getFirstName())).body(FormDemoDtoResponse);
        }catch (Exception e){
            throw new AppException("Request failed with error: "+ e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/form-demo")
    public ResponseEntity<List<FormDemoDto>> getData(){
        try{
            List<FormDemoDto> formDemoDtoList = formDemoService.getData();
            return ResponseEntity.ok(formDemoDtoList);
        }catch (Exception e){
            throw new AppException("Request failed with error: "+ e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/form-demo/{id}")
    public ResponseEntity<FormDemoDto> updateForm(@PathVariable long id,@RequestBody FormDemoDto formDemoDto){
        try{
            FormDemoDto responseformDemoDto = formDemoService.updateForm(id,formDemoDto);
            return ResponseEntity.ok(responseformDemoDto);
        }catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/form-demo/{id}")
    public ResponseEntity<FormDemoDto> deleteFormDelete(@PathVariable long id){
        try {
            //Calling the service
            FormDemoDto formDemoDto = formDemoService.deleteFormDemo(id);
            return ResponseEntity.ok(formDemoDto);
        }catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
