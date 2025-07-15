package com.bit.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name="customer_registration")
public class CustomerRegistrationEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long customerId;

    @Column(name="customer_type")
    private String customerType;

    @Column(name="customer_name")
    private String customerName;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="contact_no")
    private String contactNo;

    @Column(name="email")
    private String email;

    @Column(name="address")
    private String address;

    public CustomerRegistrationEntity() {
    }

    public CustomerRegistrationEntity(long customerId, String customerType, String customerName, String firstName, String lastName, String contactNo, String email, String address) {
        this.customerId = customerId;
        this.customerType = customerType;
        this.customerName = customerName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNo = contactNo;
        this.email = email;
        this.address = address;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
}
