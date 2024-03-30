package com.MainApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.PlayMarker.usermanagement.User;
import com.PlayMarker.usermanagement.UserRepository;


@SpringBootApplication
public class PlayMarkerApplication {


	public static void main(String[] args) {
		SpringApplication.run(PlayMarkerApplication.class, args);	
		 
	  }


    
}
        // Use userRepository to interact with the database
        // For  example, save a new user
      
 
