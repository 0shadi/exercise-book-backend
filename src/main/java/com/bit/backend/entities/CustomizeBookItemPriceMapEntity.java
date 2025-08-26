package com.bit.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "item_price_map")
public class CustomizeBookItemPriceMapEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long itemId;

    @Column(name = "item")
    private String item;

    @Column(name = "type")
    private String type;

    @Column(name = "price")
    private double price;

    public CustomizeBookItemPriceMapEntity() {
    }

    public CustomizeBookItemPriceMapEntity(long itemId, String item, String type,  double price) {
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
