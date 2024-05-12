package com.infoway.lms.representation.response;

public class AuthenticationResponse {
    private String message;
    private int statusCode;  // Renamed for clarity: Indicates the specific outcome
    private String details;  // Additional details about the authentication

    public AuthenticationResponse(String message, int statusCode, String details) {
        this.message = message;
        this.statusCode = statusCode;
        this.details = details;
    }

    // Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    // Optional: Override toString for easy logging
    @Override
    public String toString() {
        return "AuthenticationResponse{" +
                "message='" + message + '\'' +
                ", statusCode=" + statusCode +
                ", details='" + details + '\'' +
                '}';
    }
}

