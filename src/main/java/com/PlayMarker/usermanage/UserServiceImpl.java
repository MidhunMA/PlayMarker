package com.PlayMarker.usermanage;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional 
public class UserServiceImpl implements UserService {
	@Autowired
    UserRepository userRepository;
	
	User user;
	@Override
	public void registerUser(User user) {
		userRepository.save(user);
	}
	
	

	@Override
	public boolean loginUser(String email, String password) {
		return true;
	}

	@Override
	public String updateUser(Long id,User user) {
	User dbUser=userRepository.findById(id).orElse(null);
	String message="";
	
	if(dbUser==null) {
		message="There is no such user with id "+ id;
	}
	else {
	 if(user.getEmail()!=null && user.getUsername() !=null) {
		dbUser.setEmail(user.getEmail());
		dbUser.setUsername(user.getUsername());
		userRepository.save(dbUser);
		message="Updated username: "+dbUser.getUsername()+"\n"+ "Updated MailId: "+dbUser.getEmail() ;
	    }
	 else if(user.getEmail()!=null && user.getUsername()==null) {
		dbUser.setEmail(user.getEmail());
		userRepository.save(dbUser);
		message="Updated MailId: "+dbUser.getEmail()+" for the user : "+dbUser.getUsername() ;
		 }
	 else if(user.getEmail()==null && user.getUsername()!=null) {
		dbUser.setUsername(user.getUsername());
		userRepository.save(dbUser);
		message="Updated UserName: "+dbUser.getUsername()+" for the user : "+dbUser.getUsername() ;
		}
	}
	
	return message;

	}


	@Override
	public User findUsername(String email) {
	  return userRepository.findByEmail(email);
	}



	@Override
	public void deleteUser(String username) {
		userRepository.deleteByUsername(username);
		
	}

}
