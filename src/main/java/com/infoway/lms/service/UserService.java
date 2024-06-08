package com.infoway.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.infoway.lms.dao.UserPasswordRepository;
import com.infoway.lms.dao.UserRepository;
import com.infoway.lms.dto.response.AuthenticationResponse;
import com.infoway.lms.model.User;
import com.infoway.lms.model.UserPassword;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserPasswordRepository userPasswordRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthenticationResponse authenticateUser(String username, String password) {
        try {
            User user = userRepository.findByUserId(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

            UserPassword userPassword = userPasswordRepository.findByUserId(username)
                    .orElseThrow(() -> new UsernameNotFoundException("Password not set for user: " + username));

            if (!passwordEncoder.matches(password, userPassword.getPasswordHash())) {
                return new AuthenticationResponse(username, "Invalid password", 1);
            }

            String role = user.getUserRole().equals("P") ? "Privileged user" : "Normal user";
            int returnCode = user.getUserRole().equals("P") ? 3 : 2;
            return new AuthenticationResponse(user.getUserName(), role, returnCode);
        } catch (UsernameNotFoundException ex) {
            return new AuthenticationResponse(username, ex.getMessage(), 1);
        }
    }
}
