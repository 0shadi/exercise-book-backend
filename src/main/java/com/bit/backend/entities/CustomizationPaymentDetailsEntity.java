package com.bit.backend.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="customization-paymentDetails")
public class CustomizationPaymentDetailsEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name="order_id")
    private long orderId;

    @Column(name="name")
    private String name;

    @Column(name="number")
    private String number;

    @Column(name="exp_date")
    private LocalDate expDate;

    @Column(name="cvv")
    private String cvv;

    public CustomizationPaymentDetailsEntity() {
    }

    public CustomizationPaymentDetailsEntity(long id, long orderId, String name, String number, LocalDate expDate, String cvv) {
        this.id = id;
        this.orderId = orderId;
        this.name = name;
        this.number = number;
        this.expDate = expDate;
        this.cvv = cvv;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public void setExpDate(LocalDate expDate) {
        this.expDate = expDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}
