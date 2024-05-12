package com.infoway.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.infoway.lms.dao.UserPasswordRepository;
import com.infoway.lms.dao.UserRepository;
import com.infoway.lms.model.User;
import com.infoway.lms.model.UserPassword;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserPasswordRepository userPasswordRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Fetch user details from the User_table
        User user = userRepository.findByUserId(username)
            .orElseThrow(() -> new UsernameNotFoundException("No user found with username: " + username));

        // Fetch password hash from the user_passwords table
        UserPassword userPassword = userPasswordRepository.findByUserId(username)
            .orElseThrow(() -> new UsernameNotFoundException("No password set for user: " + username));

        // You might validate the password here if needed
        // Example: if(!passwordEncoder.matches(inputPassword, userPassword.getPasswordHash())) {
        //    throw new BadCredentialsException("Password does not match for " + username);
        // }

        // Determine the user's role for authority mapping
        String role = user.getUserRole().equals("P") ? "ROLE_PRIVILEGED" : "ROLE_USER";

        // Build and return the UserDetails object
        return new org.springframework.security.core.userdetails.User(
            user.getUserId(),
            userPassword.getPasswordHash(),
            Collections.singletonList(new SimpleGrantedAuthority(role))
        );
    }
}

