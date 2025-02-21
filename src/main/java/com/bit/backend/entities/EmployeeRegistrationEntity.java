package com.bit.backend.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="employee_registration")
public class EmployeeRegistrationEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long employeeNumber;

    @Column(name="full_name")
    private String fullName;

    @Column(name="calling_name")
    private String callingName;

    @Column(name="nic_number")
    private String nic;

    @Column(name="birth_date")
    private LocalDate bDay;

    @Column(name="gender")
    private String gender;

    @Column(name="address")
    private String address;

    @Column(name="emergency_contact_number")
    private int emergencyContactNumber;

    @Column(name="email")
    private String email;

    public EmployeeRegistrationEntity() {
    }

    public EmployeeRegistrationEntity(long employeeNumber, String fullName, String callingName, String nic, LocalDate bDay, String gender, String address, int emergencyContactNumber, String email) {
        this.employeeNumber = employeeNumber;
        this.fullName = fullName;
        this.callingName = callingName;
        this.nic = nic;
        this.bDay = bDay;
        this.gender = gender;
        this.address = address;
        this.emergencyContactNumber = emergencyContactNumber;
        this.email = email;
    }

    public long getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(long employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public void setNic(String NIC) {
        this.nic = NIC;
    }

    public LocalDate getbDay() {
        return bDay;
    }

    public void setbDay(LocalDate bDay) {
        this.bDay = bDay;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getEmergencyContactNumber() {
        return emergencyContactNumber;
    }

    public void setEmergencyContactNumber(int emergencyContactNumber) {
        this.emergencyContactNumber = emergencyContactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
