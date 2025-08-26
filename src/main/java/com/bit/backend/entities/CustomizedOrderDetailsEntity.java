package com.bit.backend.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="customized-order-details")
public class CustomizedOrderDetailsEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long orderId;

    @Column(name="date")
    private LocalDate date;

    @Column(name="cost")
    private String cost;

    @Column(name="payment_method")
    private String paymentMethod;

    @Column(name="order_status")
    private String orderStatus;

    @Column(name="customer_id")
    private String customerId;

    public CustomizedOrderDetailsEntity() {
    }

    public CustomizedOrderDetailsEntity(long orderId, LocalDate date, String cost, String paymentMethod, String orderStatus, String customerId) {
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
