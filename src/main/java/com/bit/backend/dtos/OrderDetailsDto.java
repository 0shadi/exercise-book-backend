package com.bit.backend.dtos;

import java.time.LocalDate;

public class OrderDetailsDto {
    private long id;
    private long orderId;
    private LocalDate date;
    private String totalCost;
    private String paymentMethod;

    public OrderDetailsDto() {
    }

    public OrderDetailsDto(long id, long orderId, LocalDate date, String totalCost, String paymentMethod) {
        this.id = id;
        this.orderId = orderId;
        this.date = date;
        this.totalCost = totalCost;
        this.paymentMethod = paymentMethod;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(String totalCost) {
        this.totalCost = totalCost;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
