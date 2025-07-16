package com.bit.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name="stock")
public class StockEntitiy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "stockItemID")
    private int stockItemID;

    @Column(name = "stockItemName")
    private String stockItemName;

    @Column(name = "qty")
    private int qty;



    public StockEntitiy() {
    }

    public StockEntitiy(Long id, int stockItemID, String stockItemName, int qty) {
        this.id = id;
        this.stockItemID = stockItemID;
        this.stockItemName = stockItemName;
        this.qty = qty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStockItemID() {
        return stockItemID;
    }

    public void setStockItemID(int stockItemID) {
        this.stockItemID = stockItemID;
    }

    public String getStockItemName() {
        return stockItemName;
    }

    public void setStockItemName(String stockItemName) {
        this.stockItemName = stockItemName;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }


}
