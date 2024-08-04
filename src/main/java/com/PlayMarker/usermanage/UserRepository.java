package com.PlayMarker.usermanage;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Additional custom query methods if  needed
	
	@Query("SELECT u FROM User u WHERE u.email = :email")
	User findByEmail(@Param("email") String email);
    
	@Transactional
	@Modifying
	@Query("DELETE FROM User u WHERE u.username = :username")
	void deleteByUsername(@Param("username") String username);
    
	@Query("SELECT u FROM User u WHERE u.username = :username")
	User findByUsername(@Param("username") String username);
    
	
}