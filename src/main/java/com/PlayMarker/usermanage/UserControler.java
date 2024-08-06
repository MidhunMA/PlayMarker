package com.PlayMarker.usermanage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PlayMarker.Exceptions.GroundFilledException;
import com.PlayMarker.playground.PlayGroundDO;


@RestController
@RequestMapping("/user")
public class UserControler {
	@Autowired
	UserService userService;

	@PostMapping("/addUser")
	public ResponseEntity<UserDO> addUser(@RequestBody UserDO user) {

		UserDO userR=userService.registerUser(user);
		return new ResponseEntity<UserDO>(userR,HttpStatus.ACCEPTED);
	}

	@GetMapping("/getUser/{username}")
	public UserDO getUser(@PathVariable String username) {
		return userService.getUser(username);

	}

	@PutMapping("/updateUserDetails/{username}")
	public ResponseEntity<UserDO> updateUserDetails(@RequestBody UserDO user, @PathVariable String username) {
		UserDO userR= userService.updateUser(username,user);
		return new ResponseEntity<UserDO>(userR,HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/deleteUser/{username}")
	public ResponseEntity<String> deleteUser(@PathVariable String username ){
     String status= userService.deleteUser(username);
     return new ResponseEntity<String>(status,HttpStatus.OK);
     
	}

	@PutMapping("/addGroundToPlayer/{playGroundName}/{playerName}")
	public ResponseEntity<String> addGroundToPlayer(@PathVariable String playerName,@PathVariable String playGroundName)
	{
		String status=userService.addGroundToPlayer(playerName,playGroundName);
		return new ResponseEntity<String>(status,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/removeGroundFromPlayer/{playGroundName}/{playerName}")
	public ResponseEntity<String> removeGroundFromPlayer(@PathVariable String playerName,@PathVariable String playGroundName)
	{
		String status=userService.removeGroundFromPlayer(playerName,playGroundName);
		return new ResponseEntity<String>(status,HttpStatus.ACCEPTED);
	}
	
	
}
