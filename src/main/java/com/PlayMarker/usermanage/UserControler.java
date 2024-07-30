package com.PlayMarker.usermanage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.PlayMarker.playground.PlayGroundDO;


@RestController
@RequestMapping("/user")
public class UserControler {
	@Autowired
	UserService userService;

	@PostMapping("/addUser")
	public UserDO addUser(@RequestBody UserDO user) {

		return userService.registerUser(user);
	}

	@GetMapping("/getUser/{username}")
	public UserDO getUser(@PathVariable String username) {
		return userService.getUser(username);

	}

	@PutMapping("/updateUserDetails")
	public UserDO updateUserDetails(@RequestBody UserDO user) {
		return userService.updateUser(user);
	}

	@DeleteMapping("/deleteUser/{username}")
	public UserDO deleteUser(@PathVariable String username ){
     return userService.deleteUser(username);
	}

	@PostMapping("/addGroundToPlayer/{playerName}")
	public UserDO addGroundToPlayer(@PathVariable String playerName,@RequestBody PlayGroundDO playGround)
	{
		return  userService.addGroundToPlayer(playerName,playGround);
	}
}
