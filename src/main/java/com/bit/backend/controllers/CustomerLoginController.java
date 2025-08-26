package com.bit.backend.controllers;

import com.bit.backend.dtos.*;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.CustomerLoginServiceI;
import com.bit.backend.services.UserServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class CustomerLoginController {
    private final CustomerLoginServiceI customerLoginServiceI;
    private final UserServiceI userServiceI;

    public CustomerLoginController(CustomerLoginServiceI customerLoginServiceI, UserServiceI userServiceI) {
        this.customerLoginServiceI = customerLoginServiceI;
        this.userServiceI = userServiceI;
    }

    @PostMapping("/customer-login")
    public ResponseEntity<CustomerLoginDto> addCustomerLogin(@RequestBody CustomerLoginDto customerLoginDto){
        customerLoginDto.setRole("CUSTOMER");
        CustomerLoginDto loginDto = customerLoginDto;

        String password = new String(customerLoginDto.getPassword());
        String firstName = "";
        String lastName = "";

        customerLoginDto.setPassword(null);
        loginDto.setPassword(null);

        try{

            if (customerLoginDto.getCustomerType().equals("Retailer")) {
                customerLoginDto.setLastName("Corporate");
                customerLoginDto.setFirstName(customerLoginDto.getCustomerName());
                firstName = customerLoginDto.getCustomerName();
                lastName = customerLoginDto.getLastName();
            } else {
                firstName = customerLoginDto.getFirstName();
                lastName = customerLoginDto.getLastName();
            }

            SignUpDto signUpDto = new SignUpDto(firstName, lastName, customerLoginDto.getUserName(), password.toCharArray(), customerLoginDto.getRole(), null, null);

            // validation to check if login name has spaces
            if (customerLoginDto.getUserName().contains(" ")) {
                throw new AppException("Username cannot contain spaces", HttpStatus.NOT_FOUND);
            }

            // add validations to check login already exists for customer
            boolean customerExist = customerLoginServiceI.checkIfCustomerExist(customerLoginDto);

            if (customerExist) {
                throw new AppException("Customer already has a login!", HttpStatus.NOT_FOUND);
            }

            // add validations to check user name
            boolean userExist = userServiceI.checkIfUserNameExist(customerLoginDto.getUserName());

            if (userExist) {
                throw new AppException("User Name Already Exists", HttpStatus.NOT_FOUND);
            }

            /*Create Login Entity*/
            CustomerLoginDto customerLoginDtoResponse = customerLoginServiceI.addCustomerLoginEntity(customerLoginDto);
            /*Create User Entity*/
            UserDto user = userServiceI.register(signUpDto, "loginpath");

            if (user.getId() != null) {
                long loginId = customerLoginDtoResponse.getId();
                long userId = user.getId();
                CustomerLoginDto newLoginDto = customerLoginDtoResponse;
                newLoginDto.setUserId(userId);
                loginDto = customerLoginServiceI.updateCustomer(loginId, newLoginDto);

                SignUpDto updatedSignUpDto = new SignUpDto(firstName, lastName, loginDto.getUserName(),password.toCharArray(),"CUSTOMER",
                                                                                                                null, loginDto.getId());

                boolean isCustomerUpdated = userServiceI.updateUser(updatedSignUpDto, userId);

            }

            return ResponseEntity.created(URI.create("/customer-login" + loginDto.getId())).body(loginDto);

        }catch (Exception e){
            throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/customer-login")
    public ResponseEntity<List<CustomerLoginDto>> getCustomerLogin(){
        try{
            List<CustomerLoginDto> customerLoginDtoList=customerLoginServiceI.getCustomerLoginEntity();
            return ResponseEntity.ok (customerLoginDtoList);
        }catch (Exception e){
            throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/customer-login/{id}")
    public ResponseEntity<CustomerLoginDto> updateCustomer(@PathVariable long id, @RequestBody CustomerLoginDto customerLoginDto){
        try{

            // validation to check if login name has spaces
            if (customerLoginDto.getUserName().contains(" ")) {
                throw new AppException("Username cannot contain spaces", HttpStatus.NOT_FOUND);
            }

            CustomerLoginDto oldCustomerLoginDto = customerLoginServiceI.getCustomerLogin(id);
            boolean userExist = userServiceI.checkIfUserNameExistForOtherUsers(customerLoginDto.getUserName(), oldCustomerLoginDto.getUserId());

            if (userExist) {
                throw new AppException("User Name Already Exists", HttpStatus.NOT_FOUND);
            }

            String password = "";
            char[] passwordArray = new char[0];

            if (customerLoginDto.getPassword() != null && !customerLoginDto.getPassword().isEmpty()) {
                passwordArray = customerLoginDto.getPassword().toCharArray();
            }
            customerLoginDto.setPassword(null);
            customerLoginDto.setRole("CUSTOMER");
            CustomerLoginDto  updatedCustomer=customerLoginServiceI.updateCustomer(id,customerLoginDto);
            customerLoginDto.setUserId(updatedCustomer.getUserId());

            String firstName = "";
            String lastName = "";

            if (customerLoginDto.getCustomerType().equals("Retailer")) {
                customerLoginDto.setLastName("Corporate");
                firstName = customerLoginDto.getCustomerName();
                lastName = customerLoginDto.getLastName();
            } else {
                firstName = customerLoginDto.getFirstName();
                lastName = customerLoginDto.getLastName();
            }

            SignUpDto signUpDto = new SignUpDto(firstName, lastName, customerLoginDto.getUserName(), passwordArray, customerLoginDto.getRole(), null, id);
            boolean value = userServiceI.updateUser(signUpDto, customerLoginDto.getUserId());
            return ResponseEntity.ok(updatedCustomer);
        }catch (Exception e){
            throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/customer-login/{id}")
    public ResponseEntity<CustomerLoginDto> deleteCustomer(@PathVariable long id){
        try{
            CustomerLoginDto  deletedCustomer=customerLoginServiceI.deleteCustomer(id);
            return ResponseEntity.ok(deletedCustomer);
        }catch (Exception e){
            throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
