package com.takisite.backend.dto;

public class UserLoginRequest {
    private String email;
    private String password;

    // Getter ve Setter'lar
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}