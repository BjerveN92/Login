package com.springsecurity.login.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springsecurity.login.entity.Product;
import com.springsecurity.login.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    // constructor
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // hämta alla produkter
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    // hämta en produkt via id
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }
}
