package com.bit.backend.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SellingItemRegistrationDto {
    private long itemId;
    private String itemType;
    private String bookType;
    private String pagesCount;
    private String bookSize;
    private String itemBrand;
    private String itemName;
    private String itemDescription;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private byte[] itemImage;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String imageName;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String imageType;

    public SellingItemRegistrationDto() {
    }

    public SellingItemRegistrationDto(long itemId, String itemType, String bookType, String pagesCount, String bookSize, String itemBrand, String itemName, String itemDescription, byte[] itemImage, String imageName, String imageType) {
        this.itemId = itemId;
        this.itemType = itemType;
        this.bookType = bookType;
        this.pagesCount = pagesCount;
        this.bookSize = bookSize;
        this.itemBrand = itemBrand;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
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

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
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
