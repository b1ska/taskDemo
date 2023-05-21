package com.example.demo.model;

public class User {
    private int userId;
    private String userName;
    private String userSex;
    private int userYearOfBirthDay;
    private String userEmail;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public int getUserYearOfBirthDay() {
        return userYearOfBirthDay;
    }

    public void setUserYearOfBirthDay(int userYearOfBirthDay) {
        this.userYearOfBirthDay = userYearOfBirthDay;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

}
