package com.PlayMarker.playground;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayGroundRespository extends JpaRepository<PlayGround,Integer>{
	
	void deleteByGroundName(String groundName);

}
