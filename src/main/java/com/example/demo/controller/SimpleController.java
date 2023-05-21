package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SimpleController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/index", "/"}, method = RequestMethod.GET)
    public String getIndex() {
        return "index";
    }

    @RequestMapping(value = {"/userlist"}, method = RequestMethod.GET)
    public String getUserList(Model model) {
        List<User> userList = userService.findUser();
        model.addAttribute("userList", userList);
        return "userlist";
    }

    @GetMapping(value = "/bundle.js", produces = "application/javascript")
    @ResponseBody
    public Resource getBundle() {
        return new ClassPathResource("static/bundle.js");
    }
}
