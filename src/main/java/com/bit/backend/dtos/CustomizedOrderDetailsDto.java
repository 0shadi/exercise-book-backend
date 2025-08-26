package com.bit.backend.dtos;

import java.time.LocalDate;

public class CustomizedOrderDetailsDto {
    private long orderId;
    private LocalDate date;
    private String cost;
    private String paymentMethod;
    private String orderStatus;
    private String customerId;

    public CustomizedOrderDetailsDto() {
    }

    public CustomizedOrderDetailsDto(long orderId, LocalDate date, String cost, String paymentMethod, String orderStatus, String customerId) {
        this.orderId = orderId;
        this.date = date;
        this.cost = cost;
        this.paymentMethod = paymentMethod;
        this.orderStatus = orderStatus;
        this.customerId = customerId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
