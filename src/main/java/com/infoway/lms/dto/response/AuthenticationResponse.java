package com.infoway.lms.dto.response;

public class AuthenticationResponse {
    private String user_name;
    private String user_role;
    private int return_code;

    public AuthenticationResponse(String user_name, String user_role, int return_code) {
        this.user_name = user_name;
        this.user_role = user_role;
        this.return_code = return_code;
    }

    // Getters and Setters
    public String getUserName() {
        return user_name;
    }

    public void setUserName(String user_name) {
        this.user_name = user_name;
    }

    public String getUserRole() {
        return user_role;
    }

    public void setUserRole(String user_role) {
        this.user_role = user_role;
    }

    public int getReturnCode() {
        return return_code;
    }

    public void setReturnCode(int return_code) {
        this.return_code = return_code;
    }

    // Optional: Override toString for easy logging
    @Override
    public String toString() {
        return "AuthenticationResponse{" +
                "user_name='" + user_name + '\'' +
                ", user_role='" + user_role + '\'' +
                ", return_code=" + return_code +
                '}';
    }
}
