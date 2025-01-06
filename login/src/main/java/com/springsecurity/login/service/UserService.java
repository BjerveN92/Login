package com.springsecurity.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springsecurity.login.entity.User;
import com.springsecurity.login.repository.UserRepository;

@Service
public class UserService {

    
    private final UserRepository userRepository;

    @Autowired // här ska en parameter för BCryptPasswordEncoder in...kanske
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        
    }


    // metod för att registrera en användare 
    public User registerNewUser(User user) {
        // användaren läggs till i databasen
        return userRepository.save(user);
    }
    
}
