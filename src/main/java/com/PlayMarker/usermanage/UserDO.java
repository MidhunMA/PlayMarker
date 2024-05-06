package com.PlayMarker.usermanage;

import org.springframework.beans.factory.annotation.Autowired;

public class UserDO {
     
	@Autowired
    UserRepository userRepository;
	
	 private String username;
	 private String email;
	 private Long id;
	 
	public String getUsername() {
		return username;
	}
	
	public String getEmail() {
		return email;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public UserDO(Long id) {
		User dbUser=userRepository.findById(id).orElse(null);
		this.username=dbUser.getUsername();
		this.email=dbUser.getEmail();
		this.id=dbUser.getId();
		
		// DO for user
	}
	 
	 
}
