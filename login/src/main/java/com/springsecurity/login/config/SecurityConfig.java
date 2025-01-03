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
            // kräver inloggning 
            // just nu kommer man få ett whitelabel error när man försöker nå /myorder
            // med "Acces denied", men det är bra då vet vi att det funkar som det ska
            .requestMatchers("/myorder").authenticated() 
            // alla requests tillåtan,ingen inloggning krävs på någon endpoint(tillfällig)
            .anyRequest().permitAll()

            
            );
        
            return http.build();
                
    }
}
