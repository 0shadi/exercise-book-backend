package com.bit.backend.entities;

import jakarta.persistence.*;

//Represent the table in the data base
@Entity
@Table(name="form_demo")
public class FormDemoEntity {
    @Id
    //Auto generate id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column (name="first_name")
    private String firstName;

    @Column (name="last_name")
    private String lastName;

    @Column (name="age")
    private int age;

    @Column (name="email")
    private String email;

    //Constructor
    public FormDemoEntity() {
    }

    //Constructor
    public FormDemoEntity(long id, String firstName, String lastName, int age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }


    //Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
