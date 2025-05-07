package com.bit.backend.dtos;


public class OrderItemDetailsDto {
    private long id;
    private long orderId;
    private String itemId;
    private String itemName;
    private String itemPrice;
    private String ordQty;
    private String subTotal;

    public OrderItemDetailsDto() {
    }

    public OrderItemDetailsDto(long id, long orderId, String itemId, String itemName, String itemPrice, String ordQty, String subTotal) {
        this.id = id;
        this.orderId = orderId;
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.ordQty = ordQty;
        this.subTotal = subTotal;
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

    public String getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }
}
