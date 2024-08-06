package com.PlayMarker.playground;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;




@Repository
public interface PlayGroundRespository extends JpaRepository<PlayGround,Integer>{
	@Transactional
	@Modifying
	@Query("DELETE FROM PlayGround p WHERE p.groundName = :groundName")
    void deleteByGroundName(@Param("groundName") String groundName);
	
	
	@Query("SELECT DISTINCT p FROM PlayGround p LEFT JOIN FETCH p.confirmedUsers WHERE p.groundName = :groundName")
	Optional<PlayGround> findByGroundName(@Param("groundName") String groundName);

}
