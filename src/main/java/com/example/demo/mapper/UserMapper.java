package com.example.demo.mapper;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> findUser();

    void addNewUser(User user);

    void updateUsers(@Param("usersList") List<User> usersList);
}
