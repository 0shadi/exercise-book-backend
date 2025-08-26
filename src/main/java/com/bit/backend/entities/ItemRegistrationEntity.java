package com.bit.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name="item_registration")
public class ItemRegistrationEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long itemId;

    @Column(name="item_code")
    private String itemCode;

    @Column(name="item_name")
    private String itemName;

    @Column(name="item_type")
    private String itemType;

    @Column(name="element_type")
    private String elementType;

    @Column(name="item_brand")
    private String itemBrand;

    @Column(name="description")
    private String description;

    @Column(name="supplier")
    private String supplier;

    @Column(name="item_category")
    private String itemCategory;

    public ItemRegistrationEntity() {
    }

    public ItemRegistrationEntity(long itemId, String itemCode, String itemName, String itemType, String elementType, String itemBrand, String description, String supplier, String itemCategory) {
        this.itemId = itemId;
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.itemType = itemType;
        this.elementType = elementType;
        this.itemBrand = itemBrand;
        this.description = description;
        this.supplier = supplier;
        this.itemCategory = itemCategory;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getElementType() {
        return elementType;
    }

    public void setElementType(String elementType) {
        this.elementType = elementType;
    }

    public String getItemBrand() {
        return itemBrand;
    }

    public void setItemBrand(String itemBrand) {
        this.itemBrand = itemBrand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
}
