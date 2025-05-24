package com.bit.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name="customized-book-details")
public class CustomizedBookDetailsEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name="order_id")
    private long orderId;

    @Column(name="cover_photo",columnDefinition = "LONGBLOB")
    private byte[] coverPhoto;

    @Column(name="material")
    private String material;

    @Column(name="paper_color")
    private String paperColor;

    @Column(name="size")
    private String size;

    @Column(name="pages_count")
    private String pagesCount;

    @Column(name="paper_type")
    private String paperType;

    @Column(name="paper_quality")
    private String paperQuality;

    @Column(name="quantity")
    private String quantity;

    public CustomizedBookDetailsEntity() {
    }

    public CustomizedBookDetailsEntity(long id, long orderId, byte[] coverPhoto, String material, String paperColor, String size, String pagesCount, String paperType, String paperQuality, String quantity) {
        this.id = id;
        this.orderId = orderId;
        this.coverPhoto = coverPhoto;
        this.material = material;
        this.paperColor = paperColor;
        this.size = size;
        this.pagesCount = pagesCount;
        this.paperType = paperType;
        this.paperQuality = paperQuality;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public byte[] getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(byte[] coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getPaperColor() {
        return paperColor;
    }

    public void setPaperColor(String paperColor) {
        this.paperColor = paperColor;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPagesCount() {
        return pagesCount;
    }

    public void setPagesCount(String pagesCount) {
        this.pagesCount = pagesCount;
    }

    public String getPaperType() {
        return paperType;
    }

    public void setPaperType(String paperType) {
        this.paperType = paperType;
    }

    public String getPaperQuality() {
        return paperQuality;
    }

    public void setPaperQuality(String paperQuality) {
        this.paperQuality = paperQuality;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
