package com.infoway.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.infoway.lms.representation.request.LoginRequest;
import com.infoway.lms.representation.response.AuthenticationResponse;
import com.infoway.lms.service.UserService;

@RestController
@RequestMapping("/api")
public class AuthenticationController {

    @Autowired
    private UserService userService;

//    @PostMapping("/login")
//    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest loginRequest) {
//        AuthenticationResponse response = userService.authenticateUser(loginRequest.getUserId(), loginRequest.getPassword());
//        return ResponseEntity.ok(response);
//    }
    
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest loginRequest) {
        AuthenticationResponse response = userService.authenticateUser(loginRequest.getUserId(), loginRequest.getPassword());
        if(response.getStatusCode() == 1) {
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok(response);
    }
}
