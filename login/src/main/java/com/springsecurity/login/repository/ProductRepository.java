package com.springsecurity.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springsecurity.login.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
