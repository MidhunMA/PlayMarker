package com.PlayMarker.playground;


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


@RestController
@RequestMapping("/Ground")
public class PlayGroundController {
	
	@Autowired
	PlayGroundService playGroundService;
	
	@PostMapping("/addGround")
	public PlayGroundDO addGround(@RequestBody PlayGroundDO playGround) {
		return playGroundService.addGround(playGround);
		
	}
	
	@GetMapping("/getGround/{groundName}")
	public PlayGroundDO getGround(@PathVariable String groundName) {
		return playGroundService.getGround(groundName);
		
		
	}
	
	@PutMapping("/updateGround/{groundName}")
	public PlayGroundDO updateGround(@PathVariable String groundName,@RequestBody PlayGroundDO playGround) {
		return playGroundService.updateGround(groundName,playGround); 
	}
	
	
	
	@DeleteMapping("/deleteGround/{groundName}")
	public ResponseEntity<String> deleteGround(@PathVariable String groundName ) {   
       String Status=playGroundService.deleteGround(groundName);
       return new ResponseEntity<>("Success",HttpStatus.OK);
     
	}
	

	
}



