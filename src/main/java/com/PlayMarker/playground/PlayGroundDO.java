package com.PlayMarker.playground;

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
	
	private String groundName;
	private Integer capacity;
	
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
        playGroundDO.setGroundName(this.groundName);
    	playGroundDO.setCapacity(this.capacity);
        return playGroundDO;
    }
	
}
