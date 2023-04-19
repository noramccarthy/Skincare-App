package com.nora.skincareApp.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class LoginUser {
	@NotEmpty(message="Email is required!")
    @Email(message="Enter a valid email.")
    private String email;
	
	@NotEmpty(message="Username is required!")
    @Size(min=3, max=40, message="User must be at least 5 characters")
    private String username;
    
    @NotEmpty(message="Password is required!")
    @Size(min=5, max=128, message="Password must be at least 5 characters.")
    private String password;
    
    public LoginUser() {}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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
    
    
}
