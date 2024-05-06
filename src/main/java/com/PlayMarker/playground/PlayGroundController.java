package com.PlayMarker.playground;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.PlayMarker.usermanage.User;
import com.PlayMarker.usermanage.UserService;

@Controller
public class PlayGroundController {
	
	@Autowired
	PlayGroundService playGroundService;
	
	@PostMapping("/addGround")
	public PlayGround addGround(@RequestBody PlayGround playGround) {
		return playGroundService.addGround(playGround);
		
	}
	
	@GetMapping("/findGround")
	public PlayGround findGround(@RequestParam String groundName ) {
		return PlayGroundService.findGround(groundName);
		
		
	}
	
	@PutMapping("/updateGround/{groundId}")
	public String updateUserDetails(@PathVariable int groundId,@RequestBody PlayGround playGround) {
		return playGroundService.updateGround(groundId, playGround); 
	}
	
	
	
	@DeleteMapping("/deleteGround")
	public String deleteUser(@RequestParam String username ) {
     userService.deleteUser(username);
     return "User "+username+" removed";
	}
}



