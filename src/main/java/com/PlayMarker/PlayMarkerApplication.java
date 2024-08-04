package com.PlayMarker;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class PlayMarkerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlayMarkerApplication.class, args);	
		
		
	  }

}
      
 
//next to fix, PlaygroundService.deleteGround delete a ground while it already added to multiple users.Issues in deleting the references...rest all works fine now
//Swagger Link: http://localhost:8080/swagger-ui/index.html