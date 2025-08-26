package com.bit.backend.dtos;

public class ProductItemsDto {
    private Long id;
    private Long itemId;
    private String categoryName;
    private String itemName;
    private Double itemQuantity;

    public ProductItemsDto() {
    }

    public ProductItemsDto(Long id, Long itemId, String categoryName, String itemName, Double itemQuantity) {
        this.id = id;
        this.itemId = itemId;
        this.categoryName = categoryName;
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Double getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(Double itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
