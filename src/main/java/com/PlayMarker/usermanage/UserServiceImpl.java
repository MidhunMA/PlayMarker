package com.PlayMarker.usermanage;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.PlayMarker.Exceptions.GroundFilledException;
import com.PlayMarker.playground.PlayGround;
import com.PlayMarker.playground.PlayGroundRespository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
    UserRepository userRepository;
	
	@Autowired
	PlayGroundRespository playGroundRespository;

	@Override
	@Transactional
	@Modifying
	public UserDO registerUser(UserDO user) {
		
		return user.dofromEntity(userRepository.save(user.toEntity()));
	}

	@Override
	@Transactional
	public UserDO getUser(String username) {
		UserDO userDO=new UserDO();
		return userDO.dofromEntity(userRepository.findByUsername(username));
	}
    
	@Transactional
	@Modifying
	@Override
	public UserDO updateUser(String username,UserDO user) {
		User user2 = new User();
		user2=userRepository.findByUsername(username);
		user2.setUsername(user.getUsername());
		user2.setEmail(user.getEmail());
		user2.setPassword(user.getPassword());
		return user.dofromEntity(userRepository.save(user2));
	}
     
	@Transactional
	@Modifying
	@Override
	public String deleteUser(String username) {
		userRepository.deleteByUsername(username);
		String status="succesfully deleted";
		return status;
	}
	
	@Override
	@Transactional
	public String addGroundToPlayer(String playerName, String playGroundName) {
		
		String status=null;
		PlayGround playGround=playGroundRespository.findByGroundName(playGroundName);
		User user=userRepository.findByUsername(playerName);
		if(playGround.getCapacity()>playGround.getConfirmedUsers().size()) {
			user.setConfirmedPlayGround(playGround);
			user.setConfirmedFlag(true);
			userRepository.save(user);
			status="Added Successfully";
		}
		else{
			throw new GroundFilledException("Ground is filled Already");
		}
		return status;
		
		
	}
	
	@Transactional
	@Modifying
	@Override
	public String removeGroundFromPlayer(String playerName, String playGroundName) {
		
		String status=null;
		User user=userRepository.findByUsername(playerName);
			user.setConfirmedPlayGround(null);
			user.setConfirmedFlag(false);
			userRepository.save(user);
			userRepository.flush();//to ensure changes are applied
			status="Removed Successfully";
		return status;
		
		
	}
	
}
