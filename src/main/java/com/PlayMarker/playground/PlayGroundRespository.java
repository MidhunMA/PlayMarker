package com.PlayMarker.playground;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface PlayGroundRespository extends JpaRepository<PlayGround,Integer>{
	
	void deleteByGroundName(String groundName);
	PlayGround findByGroundName(String groundName);

}
