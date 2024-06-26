package com.infoway.lms.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.infoway.lms.dto.request.LoginRequest;
import com.infoway.lms.dto.response.AuthenticationResponse;
import com.infoway.lms.service.UserService;

@RestController
@RequestMapping("/api")
public class AuthenticationController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest loginRequest) {
        AuthenticationResponse response = userService.authenticateUser(loginRequest.getUserId(), loginRequest.getPassword());
        if(response.getReturnCode() == 1) {
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok(response);
    }
}
