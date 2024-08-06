package com.PlayMarker.playground;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.PlayMarker.usermanage.User;
import com.PlayMarker.usermanage.UserRepository;
import com.PlayMarker.usermanage.UserService;

import jakarta.transaction.Transactional;

@Service
public class PlayGroundServiceImpl implements PlayGroundService {

	@Autowired
	PlayGroundRespository playGroundRespository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;
	
	@Transactional
	@Modifying
	@Override
	public PlayGroundDO updateGround(String groundName,PlayGroundDO playGround) {
		
		PlayGround playGroundE = new PlayGround();
		playGroundE=playGroundRespository.findByGroundName(groundName);
		playGroundE.setGroundName(playGround.getGroundName());
		playGroundE.setCapacity(playGround.getCapacity());
		return playGround.dofromEntity(playGroundRespository.save(playGroundE));
	}

	@Override
	@Transactional
	public PlayGroundDO addGround(PlayGroundDO playGround) {
	
		PlayGround playGround2=playGroundRespository.save(playGround.toEntity());
		return playGround.dofromEntity(playGround2);
		
	}
    @Transactional
	@Override
	public PlayGroundDO getGround(String groundName) {
		
		PlayGroundDO playGroundDO=new PlayGroundDO();
		 PlayGroundDO playgro = playGroundDO.dofromEntity(playGroundRespository.findByGroundName(groundName));
		return playgro;
    }

	@Override
	@Transactional
	@Modifying
	public String deleteGround(String groundName) {
		
			//deleting all references
			deleteGroundReferences(groundName);
			
		    playGroundRespository.deleteByGroundName(groundName);
		
		
		String status="Successfully_deleted";
		return status;
	}
	
	@Transactional
	@Modifying
	public void deleteGroundReferences(String groundName) {
		PlayGroundDO playground = getGround(groundName);
        for (User user : playground.getConfirmedUsers()) {
           userService.removeGroundFromPlayer(user.getUsername(), playground.getGroundName());
        }
        
        playGroundRespository.flush();
    
		
	}

	
}
