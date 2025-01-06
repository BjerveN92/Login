package com.springsecurity.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springsecurity.login.entity.User;
import com.springsecurity.login.repository.UserRepository;

@Service
public class UserService {

    
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired // här ska en parameter för BCryptPasswordEncoder in
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    // metod för att registrera en användare 
    public User registerNewUser(User user) {
        // krypterar lösenordet
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // användaren läggs till i databasen
        return userRepository.save(user);
    }
    
}
