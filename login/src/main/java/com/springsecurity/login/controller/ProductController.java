package com.springsecurity.login.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springsecurity.login.entity.Product;
import com.springsecurity.login.service.ProductService;

@Controller
public class ProductController {
    @Autowired
    private ProductService ProductService;
    
    @GetMapping("/")
    public String indexPage(Model model) {
        model.addAttribute("products", ProductService.getAllProducts());
        return "index";
    }


    @GetMapping("/product/{id}")
    public String productPage (@PathVariable Long id, Model model) {
        Optional<Product> product = ProductService.getProductById(id);
        model.addAttribute("product", product.get());
        return "product-details";
    }
    
}
