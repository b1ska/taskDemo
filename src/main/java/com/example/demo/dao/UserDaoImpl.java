package com.example.demo.dao;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findUser() {
        return userMapper.findUser();
    }

    @Override
    public void addNewUser(User user) {
        userMapper.addNewUser(user);
    }

    @Override
    public void updateUsers(List<User> usersList) {
        userMapper.updateUsers(usersList);
    }
}
