package com.PlayMarker.usermanage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class UserDO {
     
	
	 private String username;
	 private String password;
	 private String email;
	 
	 public User toEntity() {
	    	User user = new User();
	    	user.setUsername(this.username);
	    	user.setEmail(this.email);
	    	user.setPassword(this.password);
	        return user;
	    }

	    // Method to convert User entity to UserDO
	    public UserDO dofromEntity(User user) {
	        UserDO userDO = new UserDO();
	        userDO.setUsername(user.getUsername());
	    	userDO.setEmail(user.getEmail());
	    	userDO.setPassword(user.getPassword());
	    	
	        return userDO;
	    }
	 
}
