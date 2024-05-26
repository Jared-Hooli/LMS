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
            .csrf(csrf -> csrf.disable()) // Disabling CSRF for simplicity (ensure it's secured for production)
            .authorizeHttpRequests(authz -> authz
                .requestMatchers("/login", "/api/login", "/api/courses/**").permitAll() // Ensure login and specified API endpoints are publicly accessible
                .anyRequest().authenticated() // Secure all other requests
            )
            .formLogin(form -> form
                .loginPage("/login") // Ensure this is pointing to a valid login view or controller
                .defaultSuccessUrl("/home", true) // Redirect to home on success
                .permitAll()
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/login?logout")
                .permitAll()
            );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
