package com.springsecurity.login.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    
    // detta är en primärnyckel i form av ett automatiskt ID
    // använder datatypen "long" pga dess stora räckvidd av nummer
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    // resterande egenskaper för användaren
    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private String password;
    
    // getters & setters
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}
