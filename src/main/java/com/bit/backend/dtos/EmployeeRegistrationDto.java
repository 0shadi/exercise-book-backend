package com.bit.backend.dtos;

import java.time.LocalDate;

public class EmployeeRegistrationDto {
    private long employeeNumber;
    private String fullName;
    private String callingName;
    private String nic;
    private String contactNo;
    private LocalDate bDay;
    private String gender;
    private String address;
    private String emergencyContactNumber;
    private String email;
    private String jobRole;

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    public EmployeeRegistrationDto(long employeeNumber, String fullName, String callingName, String nic, String contactNo, LocalDate bDay, String gender, String address, String emergencyContactNumber, String email, String jobRole) {
        this.employeeNumber = employeeNumber;
        this.fullName = fullName;
        this.callingName = callingName;
        this.nic = nic;
        this.contactNo = contactNo;
        this.bDay = bDay;
        this.gender = gender;
        this.address = address;
        this.emergencyContactNumber = emergencyContactNumber;
        this.email = email;
        this.jobRole = jobRole;
    }

    public EmployeeRegistrationDto() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmergencyContactNumber() {
        return emergencyContactNumber;
    }

    public void setEmergencyContactNumber(String emergencyContactNumber) {
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
