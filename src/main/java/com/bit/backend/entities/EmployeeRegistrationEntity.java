package com.bit.backend.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="employee_registration")
public class EmployeeRegistrationEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long employeeNumber;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="full_name")
    private String fullName;

    @Column(name="calling_name")
    private String callingName;

    @Column(name="nic_number")
    private String nic;

    @Column(name="contact_no")
    private String contactNo;

    @Column(name="birth_date")
    private LocalDate bDay;

    @Column(name="gender")
    private String gender;

    @Column(name="address")
    private String address;

    @Column(name="emergency_contact_number")
    private String emergencyContactNumber;

    @Column(name="email")
    private String email;

    @Column(name="job_role")
    private String jobRole;

    public EmployeeRegistrationEntity(long employeeNumber, String firstName, String lastName, String fullName, String callingName, String nic, String contactNo, LocalDate bDay, String gender, String address, String emergencyContactNumber, String email, String jobRole) {
        this.employeeNumber = employeeNumber;
        this.firstName = firstName;
        this.lastName = lastName;
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

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public EmployeeRegistrationEntity() {
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

    public String getEmergencyContactNumber() {
        return emergencyContactNumber;
    }

    public void setEmergencyContactNumber(String emergencyContactNumber) {
        this.emergencyContactNumber = emergencyContactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
