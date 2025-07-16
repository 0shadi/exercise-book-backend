package com.bit.backend.dtos;


public class CustomerLoginDto {
    private Long id;
    private String customerName;
    private String firstName;
    private String lastName;
    private String customerType;
    private String userName;
    private String password;
    private String role;
    private Long userId;
    private Long customerId;

    public CustomerLoginDto() {
    }

    public CustomerLoginDto(Long id, String customerName, String firstName, String lastName, String customerType, String userName, String password, String role, Long userId, Long customerId) {
        this.id = id;
        this.customerName = customerName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerType = customerType;
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.userId = userId;
        this.customerId = customerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }
}
