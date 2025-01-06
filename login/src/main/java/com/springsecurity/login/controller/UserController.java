package com.springsecurity.login.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @GetMapping("/myorder")
    public String orderPage(Principal principal) {
        if (principal == null) {
            System.out.println("användare ej inloggad, nu ska vi skicka användaren till startsidan");
            return "redirect:/";
        }
        System.out.println("användare inloggad, nu ska vi skicka användaren till myorder");
        return "my-order";
    }
    
}
