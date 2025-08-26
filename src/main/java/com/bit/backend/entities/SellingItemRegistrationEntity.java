package com.bit.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name="selling_item_registration")
public class SellingItemRegistrationEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long itemId;

    @Column(name="item_type")
    private String itemType;

    @Column(name="book_type")
    private String bookType;

    @Column(name="pages_count")
    private String pagesCount;

    @Column(name="book_size")
    private String bookSize;

    @Column(name="item_brand")
    private String itemBrand;

    @Column(name="stationary_name")
    private String stationaryName;

    @Column(name="item_name")
    private String itemName;

    @Column(name="item_price")
    private String itemPrice;

    @Column(name="item_quantity")
    private String itemQuantity;

    @Column(name="item_image", columnDefinition = "LONGBLOB")
    private byte[] itemImage;

    @Column(name = "image_name")
    private String imageName;

    @Column(name = "image_type")
    private String imageType;

    public SellingItemRegistrationEntity() {
    }

    public SellingItemRegistrationEntity(long itemId, String itemType, String bookType, String pagesCount, String bookSize, String itemBrand, String stationaryName, String itemName, String itemPrice, String itemQuantity, byte[] itemImage, String imageName, String imageType) {
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
