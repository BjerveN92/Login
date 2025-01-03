package com.springsecurity.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @GetMapping("/myorder")
    public String orderPage() {
        return "my-order";
    }
    
}
