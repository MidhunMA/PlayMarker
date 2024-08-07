package com.PlayMarker.playground;


import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import com.PlayMarker.usermanage.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class PlayGroundDO {
	//Here we have mapped list also , so this is not good for request template,hence a separate is there
	private String groundName;
	private Integer capacity;
	@Builder.Default
	private List<User> confirmedUsers= new LinkedList<User>();
	
	
    // Method to convert PlayGroundDO to PlayGround entity
    public PlayGround toEntity() {
    	PlayGround playGround = new PlayGround();
    	playGround.setGroundName(this.groundName);
    	playGround.setCapacity(this.capacity);
        return playGround;
    }

    // Method to convert PlayGround entity to PlayGroundDO
    public PlayGroundDO dofromEntity(PlayGround playground) {
        PlayGroundDO playGroundDO = new PlayGroundDO();
        playGroundDO.setGroundName(playground.getGroundName());
    	playGroundDO.setCapacity(playground.getCapacity());
    	playGroundDO.setConfirmedUsers((List<User>) playground.getConfirmedUsers());;
        return playGroundDO;
    }
	
}
