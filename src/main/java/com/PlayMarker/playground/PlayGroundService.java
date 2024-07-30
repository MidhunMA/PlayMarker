package com.PlayMarker.playground;

public interface PlayGroundService {

	PlayGroundDO updateGround(String groundName,PlayGroundDO playGround);

	PlayGroundDO addGround(PlayGroundDO playGround);

	PlayGroundDO getGround(String groundName) ;

	String deleteGround(String groundName) ;

}
 