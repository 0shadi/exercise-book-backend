package com.bit.backend.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomizedBookDetailsDto {
    private long id;
    private long orderId;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private byte[] coverPhoto;
    private String material;
    private String paperColor;
    private String size;
    private String pagesCount;
    public String paperType;
    public String paperQuality;
    public String quantity;

    public CustomizedBookDetailsDto() {
    }

    public CustomizedBookDetailsDto(long id, long orderId, byte[] coverPhoto, String material, String paperColor, String size, String pagesCount, String paperType, String paperQuality, String quantity) {
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
