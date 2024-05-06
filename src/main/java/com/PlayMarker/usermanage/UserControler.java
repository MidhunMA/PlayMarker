package com.PlayMarker.usermanage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/User")
public class UserControler {
	@Autowired
	UserService userService;
	
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		userService.registerUser(user);
		return user;
	}
	
	@GetMapping("/findUsername")
	public String findUsername(@RequestParam String email ) {
		User user=userService.findUsername(email);
		return user.getUsername();
	}
	
	@GetMapping("/getUser/{id}")
	public UserDO getUser(@PathVariable Long id ) {
		UserDO user=userService.getUser(id);
		return user;
	}
	
	@PutMapping("/updateUserDetails/{id}")
	public String updateUserDetails(@PathVariable Long id,@RequestBody User user) {
		return userService.updateUser(id, user); 
	}
	
	
	
	@DeleteMapping("/deleteUser")
	public String deleteUser(@RequestParam String username ) {
     userService.deleteUser(username);
     return "User "+username+" removed";
	}
}
