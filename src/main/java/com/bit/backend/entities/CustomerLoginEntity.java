package com.bit.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name="customer_login")
public class CustomerLoginEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="customer_name")
    private String customerName;

    @Column(name="username")
    private String userName;

    @Column(name="password")
    private String password;

    @Column(name = "userId")
    private Long userId;

    @Column(name = "customer_id")
    private Long customerId;

    public CustomerLoginEntity() {
    }

    public CustomerLoginEntity(Long id, String customerName, String userName, String password, Long userId, Long customerId) {
        this.id = id;
        this.customerName = customerName;
        this.userName = userName;
        this.password = password;
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
}
