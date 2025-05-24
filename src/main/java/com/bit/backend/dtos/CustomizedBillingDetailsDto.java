package com.bit.backend.dtos;

public class CustomizedBillingDetailsDto {
    private long id;
    private long orderId;
    private String firstName;
    private String lastName;
    private String address;
    private String district;
    private String nearestCity;
    private String postalCode;
    private String contactNo;
    private String email;
    private String notes;

    public CustomizedBillingDetailsDto() {
    }

    public CustomizedBillingDetailsDto(long id, long orderId, String firstName, String lastName, String address, String district, String nearestCity, String postalCode, String contactNo, String email, String notes) {
        this.id = id;
        this.orderId = orderId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.district = district;
        this.nearestCity = nearestCity;
        this.postalCode = postalCode;
        this.contactNo = contactNo;
        this.email = email;
        this.notes = notes;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getNearestCity() {
        return nearestCity;
    }

    public void setNearestCity(String nearestCity) {
        this.nearestCity = nearestCity;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
