package com.example.bai_1.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Khong duoc de trong, tren 5 va duoi 45 ki tu.")
    @Size(min = 5, max = 45)
    private String firstname;
    @NotBlank(message = "Khong duoc de trong, tren 5 va duoi 45 ki tu.")
    @Size(min = 5, max = 45)
    private String lastname;
    @Pattern(regexp = "^0[0-9]{9}$", message = "so dien thoai phai bat dau bang 0 va du 10 so")
    private String phoneNumber;
    @Min(value = 18, message = "tuoi phai du 18.")
    private int age;
    @Email(message = "khong dung dinh dang email. ")
    private String email;

    public User() {
    }

    public User(int id, String firstname, String lastname, String phoneNumber, int age, String email) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
