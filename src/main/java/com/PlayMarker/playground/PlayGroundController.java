package com.PlayMarker.playground;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/Ground")
public class PlayGroundController {
	
	@Autowired
	PlayGroundService playGroundService;
	
	@PostMapping("/addGround")
	public PlayGround addGround(@RequestBody PlayGround playGround) {
		return playGroundService.addGround(playGround);
		
	}
	
	@GetMapping("/getGround/{groundId}")
	public PlayGround findGround(@PathVariable Integer groundId ) {
		return playGroundService.getGround(groundId);
		
		
	}
	
	@PutMapping("/updateGround/{groundId}")
	public String updateGround(@PathVariable Integer groundId,@RequestBody PlayGround playGround) {
		return playGroundService.updateGround(groundId, playGround); 
	}
	
	
	
	@DeleteMapping("/deleteGround/{groundId}")
	public String deleteGround(@PathVariable Integer groundId ) {
     
     return playGroundService.deleteGround(groundId);
     
	}
}



