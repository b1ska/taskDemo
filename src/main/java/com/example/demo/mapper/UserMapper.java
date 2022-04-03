package com.example.demo.mapper;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    public List<User> findUser();
    public void addNewUser(User user);
    public void updateUsers(@Param("usersList")List<User> usersList);
}
