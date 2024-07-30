package com.PlayMarker.usermanage;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PlayMarker.playground.PlayGround;
import com.PlayMarker.playground.PlayGroundDO;
import com.PlayMarker.playground.PlayGroundRespository;

import jakarta.transaction.Transactional;

@Service
@Transactional 
public class UserServiceImpl implements UserService {
	@Autowired
    UserRepository userRepository;
	
	@Autowired
	PlayGroundRespository playGroundRespository;

	@Override
	public UserDO registerUser(UserDO user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDO getUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDO updateUser(UserDO user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDO deleteUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDO addGroundToPlayer(String playerName, PlayGroundDO playGround) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
