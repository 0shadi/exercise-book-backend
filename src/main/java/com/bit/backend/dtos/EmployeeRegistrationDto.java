package com.bit.backend.dtos;

import java.time.LocalDate;

public class EmployeeRegistrationDto {
    private long employeeNumber;
    private String fullName;
    private String callingName;
    private String nic;
    private LocalDate bDay;
    private String gender;
    private String address;
    private int emergencyContactNumber;
    private String email;

    public EmployeeRegistrationDto() {
    }

    public EmployeeRegistrationDto(String email, int emergencyContactNumber, String address, String gender, LocalDate bDay, String nic, String callingName, String fullName, long id) {
        this.email = email;
        this.emergencyContactNumber = emergencyContactNumber;
        this.address = address;
        this.gender = gender;
        this.bDay = bDay;
        this.nic = nic;
        this.callingName = callingName;
        this.fullName = fullName;
        this.employeeNumber = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEmergencyContactNumber() {
        return emergencyContactNumber;
    }

    public void setEmergencyContactNumber(int emergencyContactNumber) {
        this.emergencyContactNumber = emergencyContactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getbDay() {
        return bDay;
    }

    public void setbDay(LocalDate bDay) {
        this.bDay = bDay;
    }

    public String getCallingName() {
        return callingName;
    }

    public void setCallingName(String callingName) {
        this.callingName = callingName;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public long getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(long employeeNumber) {
        this.employeeNumber = employeeNumber;
    }
}
