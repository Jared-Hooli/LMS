package com.infoway.lms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // Disable CSRF protection for simplicity (not recommended for production)
            .csrf(csrf -> csrf.disable())
            // Configure URL authorization
            .authorizeHttpRequests(authz -> authz
                .requestMatchers("/api/login", "/api/register").permitAll() // Publicly accessible endpoints
                .anyRequest().authenticated() // All other requests require authentication
            )
            // Configure form login
            .formLogin(form -> form
                .loginPage("/login") // Custom login page
                .defaultSuccessUrl("/home", true) // Redirect after successful login
                .permitAll()
            )
            // Configure logout
            .logout(logout -> logout
                .logoutSuccessUrl("/login?logout") // Redirect after logout
                .permitAll()
            );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}