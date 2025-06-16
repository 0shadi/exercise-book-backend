package com.bit.backend.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="order-details")
public class OrderDetailsEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name="order_id")
    private long orderId;

    @Column(name="date")
    private LocalDate date;

    @Column(name="total_cost")
    private String totalCost;

    @Column(name="payment_method")
    private String paymentMethod;

    @Column(name="order_status")
    private String orderStatus;

    @Column(name="customer_id")
    private String customerId;

    public OrderDetailsEntity() {
    }

    public OrderDetailsEntity(long id, long orderId, LocalDate date, String totalCost, String paymentMethod, String orderStatus, String customerId) {
        this.id = id;
        this.orderId = orderId;
        this.date = date;
        this.totalCost = totalCost;
        this.paymentMethod = paymentMethod;
        this.orderStatus = orderStatus;
        this.customerId = customerId;
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
