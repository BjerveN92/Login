package com.springsecurity.login.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

    // detta är en primärnyckel i form av ett automatiskt ID
    // använder datatypen "long" pga dess stora räckvidd av nummer
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    // resterande egenskaper för produkten
    private String name;
    private String description;
    private double price;
    // bilder sparas lokalt i detta fall men styrs av en URL i databasen
    @Column(name = "image_url")
    private String imageUrl;
    
    // getters & setters 
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}