package com.example.Trab_ArquiteturaDeSoftware.DTO;

public class RegisterRequest {
    private String username;
    private String password;
    private String role = "USER";
    
    // Construtores
    public RegisterRequest() {}
    
    public RegisterRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public RegisterRequest(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
    
    // Getters e Setters
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getRole() {
        return role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
}

