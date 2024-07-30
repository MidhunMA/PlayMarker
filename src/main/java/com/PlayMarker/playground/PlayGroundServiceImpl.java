package com.PlayMarker.playground;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import jakarta.transaction.Transactional;

@Service
@Transactional 
public class PlayGroundServiceImpl implements PlayGroundService {

	@Autowired
	PlayGroundRespository playGroundRespository;
	
	@Override
	public PlayGroundDO updateGround(String groundName,PlayGroundDO playGround) {
		
		PlayGround playGroundE = new PlayGround();
		playGroundE=playGroundRespository.findByGroundName(groundName);
		playGroundE.setGroundName(playGround.getGroundName());
		playGroundE.setCapacity(playGround.getCapacity());
		return playGround.dofromEntity(playGroundE);
	}

	@Override
	public PlayGroundDO addGround(PlayGroundDO playGround) {
	PlayGround playGround2=playGroundRespository.save(playGround.toEntity());
	return playGround.dofromEntity(playGround2);
		
	}

	@Override
	public PlayGroundDO getGround(String groundName) {
		
		PlayGroundDO playGroundDO=new PlayGroundDO();
		return playGroundDO.dofromEntity(playGroundRespository.findByGroundName(groundName));
	}

	@Override
	public String deleteGround(String groundName) {
		
		
		playGroundRespository.deleteByGroundName(groundName);
		String status="Successfully_deleted";
		return status;
	}

	
}
