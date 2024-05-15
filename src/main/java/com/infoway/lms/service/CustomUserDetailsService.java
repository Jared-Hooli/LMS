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
        User user = userRepository.findByUserId(username)
            .orElseThrow(() -> new UsernameNotFoundException("No user found with username: " + username));

        UserPassword userPassword = userPasswordRepository.findByUserId(username)
            .orElseThrow(() -> new UsernameNotFoundException("No password set for user: " + username));

        String role = user.getUserRole().equals("P") ? "ROLE_PRIVILEGED" : "ROLE_USER";

        return new org.springframework.security.core.userdetails.User(
            user.getUserId(),
            userPassword.getPasswordHash(),
            Collections.singletonList(new SimpleGrantedAuthority(role))
        );
    }
}
