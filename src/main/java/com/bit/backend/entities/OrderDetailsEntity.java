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
    private String orderId;

    @Column(name="date")
    private LocalDate date;

    @Column(name="total_cost")
    private String totalCost;

    @Column(name="payment_method")
    private String paymentMethod;

    public OrderDetailsEntity() {
    }

    public OrderDetailsEntity(long id, String orderId, LocalDate date, String totalCost, String paymentMethod) {
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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
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
