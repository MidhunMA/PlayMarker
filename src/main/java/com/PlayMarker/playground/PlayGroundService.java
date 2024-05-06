package com.PlayMarker.playground;

public interface PlayGroundService {

	String updateGround(Integer groundId, PlayGround playGround);

	PlayGround addGround(PlayGround playGround);

	 PlayGround getGround(Integer groundId) ;

	 String deleteGround(Integer groundId) ;

}
 