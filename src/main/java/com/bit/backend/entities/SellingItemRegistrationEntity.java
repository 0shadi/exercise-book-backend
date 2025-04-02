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

    @Column(name="item_name")
    private String itemName;

    @Column(name="item_description")
    private String itemDescription;

    @Column(name="item_image", columnDefinition = "LONGBLOB")
    private byte[] itemImage;

    @Column(name = "image_name")
    private String imageName;

    @Column(name = "image_type")
    private String imageType;

    public SellingItemRegistrationEntity() {
    }

    public SellingItemRegistrationEntity(long itemId, String itemType, String bookType, String pagesCount, String bookSize, String itemBrand, String itemName, String itemDescription, byte[] itemImage) {
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
