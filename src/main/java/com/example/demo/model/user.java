package com.example.demo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userID")
    private Integer userID;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "email")
    private String email;



    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "gender")
    private String gender;


    @Column(name = "address")
    private String address;



    @Column(name = "fund")
    private Integer fund;


    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public Integer getFund() {
        return fund;
    }

    public void setFund(Integer fund) {
        this.fund = fund;
    }
}
