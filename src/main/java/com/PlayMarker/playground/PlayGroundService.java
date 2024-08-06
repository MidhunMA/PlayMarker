package com.PlayMarker.playground;

public interface PlayGroundService {

	PlayGroundDO updateGround(String groundName,PlayGroundRequestTemplate playGround);

	PlayGroundDO addGround(PlayGroundRequestTemplate playGround);

	PlayGroundDO getGround(String groundName) ;

	String deleteGround(String groundName) ;

}
 