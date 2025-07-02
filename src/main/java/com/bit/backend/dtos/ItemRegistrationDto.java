package com.bit.backend.dtos;

public class ItemRegistrationDto {
    private long itemId;
    private String itemCode;
    private String itemName;
    private String itemType;
    private String elementType;
    private String itemBrand;
    private String description;
    private String itemCategory;
    private String supplier;

    public ItemRegistrationDto() {
    }

    public ItemRegistrationDto(long itemId, String itemCode, String itemName, String itemType, String elementType, String itemBrand, String description, String itemCategory, String supplier) {
        this.itemId = itemId;
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.itemType = itemType;
        this.elementType = elementType;
        this.itemBrand = itemBrand;
        this.description = description;
        this.itemCategory = itemCategory;
        this.supplier = supplier;
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
