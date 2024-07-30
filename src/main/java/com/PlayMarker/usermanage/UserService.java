package com.PlayMarker.usermanage;

import com.PlayMarker.playground.PlayGround;
import com.PlayMarker.playground.PlayGroundDO;

public interface UserService {

	UserDO registerUser(UserDO user);

	UserDO getUser(String username);

	UserDO updateUser(UserDO user);

	UserDO deleteUser(String username);

	UserDO addGroundToPlayer(String playerName, PlayGroundDO playGround);

   
}