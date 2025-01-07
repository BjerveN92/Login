package com.springsecurity.login.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {
    
    // detta är en primärnyckel i form av ett automatiskt ID
    // använder datatypen "long" pga dess stora räckvidd av nummer
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    // resterande egenskaper för användaren
    @Column(name = "firstname", nullable=false)
    private String firstname;
    @Column(name = "lastname", nullable=false)
    private String lastname;
    @Column(name = "email", unique=true, nullable=false)
    private String email;
    @Column(name = "username", unique=true, nullable=false)
    private String username;
    @Column(name = "password", nullable=false)
    private String password;

    // default konstruktor
    public User() {}
    
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
