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
	public String updateGround(Integer groundId, PlayGround playGround) {
		

		PlayGround dbPlayGround=playGroundRespository.findById(groundId).orElse(null);
		String message="";
		
		if(dbPlayGround==null) {
			message="There is no such Ground with id "+ groundId;
		}
		else {
		 if(playGround.getCapacity()!=null && playGround.getGroundName() !=null) {
			dbPlayGround.setCapacity(playGround.getCapacity());
			dbPlayGround.setGroundName(playGround.getGroundName());
			playGroundRespository.save(dbPlayGround);
			message="Updated GroundName: "+dbPlayGround.getGroundName()+"\n"+ "Updated Capacity: "+dbPlayGround.getCapacity() ;
		    }
		 else if(playGround.getCapacity()!=null && playGround.getGroundName()==null) {
			 dbPlayGround.setCapacity(playGround.getCapacity());
			 playGroundRespository.save(dbPlayGround);
			message="Updated Capacity: "+dbPlayGround.getCapacity()+ " for the Ground : "+dbPlayGround.getGroundName() ;
			 }
		 else if(playGround.getCapacity()==null && playGround.getGroundName()!=null) {
			 dbPlayGround.setGroundName(playGround.getGroundName());
			 playGroundRespository.save(dbPlayGround);
			message="Updated GroundName: "+dbPlayGround.getGroundName()+" for the Ground : "+dbPlayGround.getGroundName() ;
			}
		}
		
		return message;

		}
	

	@Override
	public PlayGround addGround(PlayGround playGround) {
		
		return playGroundRespository.save(playGround);
	}

	@Override
	public PlayGround getGround(Integer groundId) {
		
		return playGroundRespository.findById(groundId).orElse(null);
	}

	@Override
	public String deleteGround(Integer groundId) {
		
		PlayGround dbPlayGround=playGroundRespository.findById(groundId).orElse(null);
		if (dbPlayGround!=null) {
			playGroundRespository.deleteById(groundId);
			return "Deleted User";
		}
		else
		{
			return "No such user";
		}
		
		}

}
