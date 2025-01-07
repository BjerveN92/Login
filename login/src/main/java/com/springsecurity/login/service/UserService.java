package com.springsecurity.login.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springsecurity.login.entity.User;
import com.springsecurity.login.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

    
    private final UserRepository userRepository;
    

    // här ska en parameter för BCryptPasswordEncoder in...kanske
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        
    }
    // metod för att registrera en användare 
    public User saveUser(User user) {
        // krypterar lösenordet innan det sparas
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // användaren läggs till i databasen
        return userRepository.save(user);
    }
    // metod för att hitta en användare
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("User not found")); 

        return org.springframework.security.core.userdetails.User
            .withUsername(user.getUsername())
            .password(user.getPassword())
            .build();
    }
    
}
