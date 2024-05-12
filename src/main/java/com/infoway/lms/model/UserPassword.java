package com.infoway.lms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "User_passwords")
public class UserPassword {
    @Id
    @Column(name = "User_id")
    private String userId;
    
    @Column(name = "Password_hash")
    private String passwordHash;

    // Constructors
    public UserPassword() {}

    public UserPassword(String userId, String passwordHash) {
        this.userId = userId;
        this.passwordHash = passwordHash;
    }

    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}

