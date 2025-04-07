package com.bit.backend.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SellingItemRegistrationDto {
    private long itemId;
    private String itemType;
    private String bookType;
    private String pagesCount;
    private String bookSize;
    private String itemBrand;
    private String stationaryName;
    private String itemName;
    private String itemPrice;
    private String itemQuantity;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private byte[] itemImage;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String imageName;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String imageType;

    public SellingItemRegistrationDto() {
    }

    public SellingItemRegistrationDto(long itemId, String itemType, String bookType, String pagesCount, String bookSize, String itemBrand, String stationaryName, String itemName, String itemPrice, String itemQuantity, byte[] itemImage, String imageName, String imageType) {
        this.itemId = itemId;
        this.itemType = itemType;
        this.bookType = bookType;
        this.pagesCount = pagesCount;
        this.bookSize = bookSize;
        this.itemBrand = itemBrand;
        this.stationaryName = stationaryName;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemQuantity = itemQuantity;
        this.itemImage = itemImage;
        this.imageName = imageName;
        this.imageType = imageType;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public String getPagesCount() {
        return pagesCount;
    }

    public void setPagesCount(String pagesCount) {
        this.pagesCount = pagesCount;
    }

    public String getBookSize() {
        return bookSize;
    }

    public void setBookSize(String bookSize) {
        this.bookSize = bookSize;
    }

    public String getItemBrand() {
        return itemBrand;
    }

    public void setItemBrand(String itemBrand) {
        this.itemBrand = itemBrand;
    }

    public String getStationaryName() {
        return stationaryName;
    }

    public void setStationaryName(String stationaryName) {
        this.stationaryName = stationaryName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(String itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public byte[] getItemImage() {
        return itemImage;
    }

    public void setItemImage(byte[] itemImage) {
        this.itemImage = itemImage;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }
}
