package com.springsecurity.login.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.springsecurity.login.entity.User;
import com.springsecurity.login.service.UserService;

@Controller
public class UserController {

    private final UserService userService;
    // konstruktor för att injecta userService
    public UserController(UserService userService) {
        this.userService = userService;
    }
    // endpoint för att registrera en användare
    @GetMapping("/register")
    public String registerPage(Model model) {
        // skapar en ny användare utan värden
        model.addAttribute("user", new User());
        return "register";
    }
    // registrerar användaren och sparar ner den i databasen
    @PostMapping("/register")
    public String registerUser(User user) {
        userService.saveUser(user);
        return "redirect:/";
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
