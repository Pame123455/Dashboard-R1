package com.cybersyn.backend.demo.models.dtos;

import com.cybersyn.backend.demo.models.entities.Role;

public class LoginResponse {
 private Long id;
    private String name;
    private String email;
    private Role role;

    
    public LoginResponse() {
    }

    public Long getId() {
      return id;
    }
    public void setId(Long id) {
      this.id = id;
    }
    public String getName() {
      return name;
    }
    public void setName(String name) {
      this.name = name;
    }
    public String getEmail() {
      return email;
    }
    public void setEmail(String email) {
      this.email = email;
    }
     public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    
}
