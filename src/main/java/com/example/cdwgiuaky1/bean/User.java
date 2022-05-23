package com.example.cdwgiuaky1.bean;

import java.text.SimpleDateFormat;
import java.util.*;

public class User {
    private String userName;
    private String password;
    private String email;
    private Date joinDate;
    private List<AMessage> messages = new ArrayList<>();

    public User(String userName, String password, String email, Date joinDate) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.joinDate = joinDate;
    }

    // GETTTER AND SETTER

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJoinDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(this.joinDate);
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }
}
