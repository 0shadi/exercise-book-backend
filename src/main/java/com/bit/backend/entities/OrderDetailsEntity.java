package com.bit.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name="order-details")
public class OrderDetailsEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long orderId;

    @Column(name="item_id")
    private String itemId;

    @Column(name="item_name")
    private String itemName;

    @Column(name="ord_qty")
    private String ordQty;

    @Column(name="total_cost")
    private String totalCost;

    @Column(name="payment_method")
    private String paymentMethod;

    public OrderDetailsEntity() {
    }

    public OrderDetailsEntity(long orderId, String itemId, String itemName, String ordQty, String totalCost, String paymentMethod) {
        this.orderId = orderId;
        this.itemId = itemId;
        this.itemName = itemName;
        this.ordQty = ordQty;
        this.totalCost = totalCost;
        this.paymentMethod = paymentMethod;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getOrdQty() {
        return ordQty;
    }

    public void setOrdQty(String ordQty) {
        this.ordQty = ordQty;
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
