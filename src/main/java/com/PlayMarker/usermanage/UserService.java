package com.PlayMarker.usermanage;

import com.PlayMarker.Exceptions.GroundFilledException;
import com.PlayMarker.playground.PlayGround;
import com.PlayMarker.playground.PlayGroundDO;

public interface UserService {

	UserDO registerUser(UserDO user);

	UserDO getUser(String username);

	UserDO updateUser(String username,UserDO user);

	String deleteUser(String username);

	String addGroundToPlayer(String playerName, String playGroundName);

	String removeGroundFromPlayer (String playerName, String playGroundName);
}