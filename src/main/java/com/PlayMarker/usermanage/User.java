package com.PlayMarker.usermanage;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    @Size(max = 30)
    @Column(unique = true)
    private String username;
    
    @NotBlank
    @Size(max = 20,min=8)
    private String password;
    
    @Column(unique = true)
    private String email;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public User(@NotBlank @Size(max = 30) String username, @NotBlank @Size(max = 20, min = 8) String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public User() {
        // Default constructor
    }

    // Constructors, getters, and setters
}
