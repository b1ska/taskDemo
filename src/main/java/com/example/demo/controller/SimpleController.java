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

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class SimpleController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/index","/"}, method = GET)
    public String getIndex(){
        return "index";
    }

    @RequestMapping(value = {"/userlist"}, method = GET)
    public @ResponseBody ResponseEntity<List<User>> getUserList() {

        List<User> listPerson = null;
        try {
            // Call to service and get the list of Users
            listPerson = userService.findUser();
            if(!CollectionUtils.isEmpty(listPerson)) {
                return new ResponseEntity<>(listPerson, HttpStatus.OK);
            } else {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        } catch(final Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @RequestMapping(value = {"/addUser"}, method = POST)
    public @ResponseBody void addNewUser(@RequestBody User user) {
        try {
            userService.addNewUser(user);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
