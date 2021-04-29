package com.example.demo.model;

public class User {
    private int userId;
    private String userName;
    private String userSex;
    private int userYearOfBirthDay;
    private String userEmail;

    public User(int userId, String userName, String userSex, int userYearOfBirthDay, String userEmail) {
        this.userId = userId;
        this.userName = userName;
        this.userSex = userSex;
        this.userYearOfBirthDay = userYearOfBirthDay;
        this.userEmail = userEmail;
    }

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

    @Override
    public String toString() {
        return "{" +
                "\"userId\":"  + "\""+userId +"\""+
                ", \"userName\":" +"\""+userName +"\""+
                ", \"userSex\":" +"\""+ userSex  +"\""+
                ", \"userYearOfBirthDay\":" +"\""+ userYearOfBirthDay +"\""+
                ", \"userEmail\":" +"\""+ userEmail+"\""
                +"}";
    }
}
