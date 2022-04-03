package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {

    List<User> findUser();
    void addNewUser(User user);
    void updateUsers(List<User> usersList);
}
