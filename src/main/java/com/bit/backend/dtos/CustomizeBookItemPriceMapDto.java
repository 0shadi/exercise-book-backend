package com.bit.backend.dtos;

public class CustomizeBookItemPriceMapDto {
    private long itemId;
    private String item;
    private String type;
    private double price;

    public CustomizeBookItemPriceMapDto() {
    }

    public CustomizeBookItemPriceMapDto(long itemId, String item, String type, double price) {
        this.itemId = itemId;
        this.item = item;
        this.price = price;
        this.type = type;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
