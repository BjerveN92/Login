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
                .requestMatchers( "/register", "/product/**", "/").permitAll()
                // kräver inloggning 
                .requestMatchers("/myorder").authenticated() 
                // resten av alla requests är tillgängligt för alla (i detta fall bara logga in/logga ut)
                .anyRequest().permitAll()
            )
            //här ska det finnas en inställning för att omdirigera användaren till startsidan(index) om åtkomst nekas
            .exceptionHandling(exception -> exception
                .authenticationEntryPoint((httpServletRequest, httpServletResponse, authenticationException) -> 
                    httpServletResponse.sendRedirect("/"))
                )
            // här är inställningar för login/logout
            .formLogin(form -> form
                .defaultSuccessUrl("/")
                .permitAll()
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/")
                .permitAll()
            );
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            // .exceptionHandling(exception -> exception
            //     .accessDeniedHandler((request, response, accessDeniedException) -> {
            //         response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
            //         response.setHeader("Location", "/");
            //     })
            // );


            
            // vid nekad åtkomst skickas användaren till startsidan(index)
            // .exceptionHandling(exception -> exception
            // .accessDeniedHandler((request, response, accessDeniedException) -> {
            //     System.out.println("Torsten Flink");
            //     response.sendRedirect("/");
            //     })
            // );
            
            
            
            
        return http.build();
                
    }
}
