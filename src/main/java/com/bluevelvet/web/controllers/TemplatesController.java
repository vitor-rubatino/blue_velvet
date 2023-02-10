package com.bluevelvet.web.controllers;

import ch.qos.logback.core.model.Model;
import com.bluevelvet.web.services.ProductService;
import com.bluevelvet.web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TemplatesController {

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;


    @GetMapping("/")
    public String homePage(Model model) {
        return "index";
    }

    @GetMapping("/login")
    public String loginPage(Model model){
        return "login";
    }

    @GetMapping("/home-user")
    public String userPage(Model model){
        return "home-user";
    }

    @GetMapping("/home-admin")
    public String adminPage(Model model){
        return "/home-admin";
    }
}
