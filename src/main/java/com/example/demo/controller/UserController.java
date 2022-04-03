package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.example.demo.util.Util.getList;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/index", "/"}, method = GET)
    public String getIndex() {
        return "index";
    }

    @RequestMapping(value = {"/userlist"}, method = GET)
    @ResponseBody
    public ResponseEntity<List<User>> getUserList() {
        List<User> listPerson;
        try {
            listPerson = userService.findUser();
            if (!CollectionUtils.isEmpty(listPerson)) {
                return new ResponseEntity<>(listPerson, HttpStatus.OK);
            } else {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        } catch (final Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = {"/addUser"}, method = POST)
    @ResponseBody
    public void addNewUser(@RequestBody User user) {
        try {
            userService.addNewUser(user);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @RequestMapping(value = {"/updateUsers"}, method = POST)
    @ResponseBody
    public void updateUsers(HttpServletRequest request) {
        try {
            String users = request.getParameter("users");
            List<User> userList = getList(users, User.class);
            userService.updateUsers(userList);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
