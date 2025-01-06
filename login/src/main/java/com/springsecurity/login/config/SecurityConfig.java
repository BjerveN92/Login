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
                // kräver ingen inloggning
                .requestMatchers( "/", "/register", "/product/**").permitAll()
                // kräver inloggning 
                .requestMatchers("/myorder").authenticated() 
                // resten av alla requests är tillgängligt för alla 
                .anyRequest().permitAll()
            )
            
            // här är inställningar för login/logout
            .formLogin(form -> form
                .defaultSuccessUrl("/", true)
                .permitAll()
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/")
                .permitAll()
            );

            // .exceptionHandling(exception -> exception
            //     .authenticationEntryPoint((request, response, authException) -> {
            //         if (request.getRequestURI().equals("/myorder")) {
            //             response.sendRedirect("/");
            //         }
            //     })
            // )
                

            

            
        return http.build();
                
    }
}
