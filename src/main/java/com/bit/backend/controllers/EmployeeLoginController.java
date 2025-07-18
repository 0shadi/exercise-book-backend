package com.bit.backend.controllers;

import com.bit.backend.dtos.*;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.EmployeeLoginServiceI;
import com.bit.backend.services.UserServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class EmployeeLoginController {
    private final EmployeeLoginServiceI employeeLoginServiceI;
    private final UserServiceI userServiceI;

    public EmployeeLoginController(EmployeeLoginServiceI employeeLoginServiceI, UserServiceI userServiceI) {
        this.employeeLoginServiceI = employeeLoginServiceI;
        this.userServiceI = userServiceI;
    }

    @PostMapping("/employee-login")
    public ResponseEntity<EmployeeLoginDto> addEntity(@RequestBody EmployeeLoginDto employeeLoginDto) {
        employeeLoginDto.setRole("EMPLOYEE");
        EmployeeLoginDto loginDto = employeeLoginDto;

        String password = new String(employeeLoginDto.getPassword());

        employeeLoginDto.setPassword(null);
        loginDto.setPassword(null);

        try{
            SignUpDto signUpDto = new SignUpDto(employeeLoginDto.getFirstName(), employeeLoginDto.getLastName(), employeeLoginDto.getUserName(),
                                                                            password.toCharArray(), employeeLoginDto.getRole(), null, null);


            // validation to check if login name has spaces
            if (employeeLoginDto.getUserName().contains(" ")) {
                throw new AppException("Username cannot contain spaces", HttpStatus.NOT_FOUND);
            }

            // validation to check if a login already exists for employee
            boolean employeeExist = employeeLoginServiceI.checkIfEmployeeExist(employeeLoginDto);

            if (employeeExist) {
                throw new AppException("Login already exists for the employee", HttpStatus.NOT_FOUND);
            }

            // validations to check user name in User table
            boolean userExist = userServiceI.checkIfUserNameExist(employeeLoginDto.getUserName());

            if (userExist) {
                throw new AppException("User Name Already Exists! Please try with different user name", HttpStatus.NOT_FOUND);
            }

            /*Create Login Entity*/
            EmployeeLoginDto employeeLoginDtoResponse = employeeLoginServiceI.addEmployeeLoginEntity(employeeLoginDto);
            /*Create User Entity*/
            UserDto user = userServiceI.register(signUpDto);

            if (user.getId() != null) {
                long loginId = employeeLoginDtoResponse.getId();
                long userId = user.getId();
                EmployeeLoginDto newLoginDto = employeeLoginDtoResponse;
                newLoginDto.setUserId(userId);
                loginDto = employeeLoginServiceI.updateEmployee(loginId, newLoginDto);

                SignUpDto updatedSignUpDto = new SignUpDto(loginDto.getFirstName(), loginDto.getLastName(),
                        loginDto.getUserName(),password.toCharArray(),"EMPLOYEE", loginDto.getId(), null);

                boolean isUserUpdated = userServiceI.updateUser(updatedSignUpDto, userId);
            }

            return ResponseEntity.created(URI.create("/employee-login" + loginDto.getId())).body(loginDto);
        }
        catch(Exception e){
            throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employee-login")
    public ResponseEntity<List<EmployeeLoginDto>> getEntity(){
        try{
            List<EmployeeLoginDto> employeeLoginList=employeeLoginServiceI.getEmployeeLoginEntity();
            return ResponseEntity.ok (employeeLoginList);
        }catch (Exception e){
            throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/employee-login/{id}")
    public ResponseEntity<EmployeeLoginDto> updateEmployee(@PathVariable long id, @RequestBody EmployeeLoginDto employeeLoginDto){
        try{
            EmployeeLoginDto oldEmployeeLogin = employeeLoginServiceI.getEmployee(id);
            boolean userExist = userServiceI.checkIfUserNameExistForOtherUsers(employeeLoginDto.getUserName(), oldEmployeeLogin.getUserId());
            if(userExist){
                throw new AppException("User name already exists",HttpStatus.NOT_FOUND);
            }

            String password = "";
            char[] passwordArray = new char[0];

            if(employeeLoginDto.getPassword() != null && !employeeLoginDto.getPassword().isEmpty()){
                passwordArray = employeeLoginDto.getPassword().toCharArray();
            }

            employeeLoginDto.setPassword(null);
            employeeLoginDto.setRole("EMPLOYEE");

            EmployeeLoginDto  updatedEmployee=employeeLoginServiceI.updateEmployee(id,employeeLoginDto);
            employeeLoginDto.setUserId(updatedEmployee.getUserId());

            SignUpDto signUpDto = new SignUpDto(employeeLoginDto.getFirstName(), employeeLoginDto.getLastName(), employeeLoginDto.getUserName(), passwordArray, employeeLoginDto.getRole(), id, null);
            boolean isUserUpdated = userServiceI.updateUser(signUpDto, employeeLoginDto.getUserId());
            return ResponseEntity.ok(updatedEmployee);
        }catch (Exception e){
            throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/employee-login/{id}")
    public ResponseEntity<EmployeeLoginDto> deleteEmployee(@PathVariable long id){
        try{
            EmployeeLoginDto  deletedEmployee=employeeLoginServiceI.deleteEmployee(id);
            return ResponseEntity.ok(deletedEmployee);
        }catch (Exception e){
            throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
