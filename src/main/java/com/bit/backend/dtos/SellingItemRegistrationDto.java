package com.bit.backend.dtos;

public class SellingItemRegistrationDto {
    private long itemId;
    private String itemType;
    private String bookType;
    private String pagesCount;
    private String bookSize;
    private String itemBrand;
    private String itemName;
    private String itemDescription;
    private byte[] itemImage;

    public SellingItemRegistrationDto() {
    }

    public SellingItemRegistrationDto(long itemId, String itemType, String bookType, String pagesCount, String bookSize, String itemBrand, String itemName, String itemDescription, byte[] itemImage) {
        this.itemId = itemId;
        this.itemType = itemType;
        this.bookType = bookType;
        this.pagesCount = pagesCount;
        this.bookSize = bookSize;
        this.itemBrand = itemBrand;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemImage = itemImage;
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
}
