package com.infoway.lms.representation.request;

public class LoginRequest {
    private String userId; // User ID which is the email address
    private String password; // Password

    // Constructors
    public LoginRequest() {
        // Default constructor
    }

    public LoginRequest(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    // Getters and setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Optional: Override toString() method for debugging purposes
    @Override
    public String toString() {
        return "LoginRequest{" +
               "userId='" + userId + '\'' +
               ", password='[PROTECTED]'" +
               '}';
    }
}

