package com.springsecurity.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {
    
    @GetMapping("/")
    public String indexPage(Model model) {
        return "index";
    }

    @GetMapping("/product/{id}")
    public String productPage (@PathVariable Long id, Model model) {
        return "product-details";
    }
    
}
