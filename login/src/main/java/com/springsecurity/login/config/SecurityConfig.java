package com.springsecurity.login.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
            // alla requests tillåtan,ingen inloggning krävs på någon endpoint(tillfällig)
            .anyRequest().permitAll()
            
            );
        
            return http.build();
                
    }
}
