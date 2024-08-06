package com.PlayMarker.playground;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.PlayMarker.usermanage.UserDO;


@RestController
@RequestMapping("/Ground")
public class PlayGroundController {
	
	@Autowired
	PlayGroundService playGroundService;
	
	@PostMapping("/addGround")
	public ResponseEntity<PlayGroundDO> addGround(@RequestBody PlayGroundRequestTemplate playGround) {
		
		PlayGroundDO playDO= playGroundService.addGround(playGround);
		return new ResponseEntity<PlayGroundDO>(playDO,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/getGround/{groundName}")
	public PlayGroundDO getGround(@PathVariable String groundName) {
		return playGroundService.getGround(groundName);
		
		
	}
	
	@PutMapping("/updateGround/{groundName}")
	public ResponseEntity<PlayGroundDO> updateGround(@PathVariable String groundName,@RequestBody PlayGroundRequestTemplate playGround) {
		PlayGroundDO playDO= playGroundService.updateGround(groundName,playGround); 
		return new ResponseEntity<PlayGroundDO>(playDO,HttpStatus.ACCEPTED);
	}
	
	
	
	@DeleteMapping("/deleteGround/{groundName}")
	public ResponseEntity<String> deleteGround(@PathVariable String groundName ) {   
       String status=playGroundService.deleteGround(groundName);
       return new ResponseEntity<>(status,HttpStatus.OK);
     
	}
	

	
}



