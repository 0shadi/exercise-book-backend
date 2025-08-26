package com.bit.backend.dtos;

import java.time.LocalDate;

public class OrderPaymentDetailsDto {
    private long id;
    private long orderId;
    private String name;
    private String number;
    private LocalDate expDate;
    private String cvv;

    public OrderPaymentDetailsDto() {
    }

    public OrderPaymentDetailsDto(long id, long orderId, String name, String number, LocalDate expDate, String cvv) {
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
