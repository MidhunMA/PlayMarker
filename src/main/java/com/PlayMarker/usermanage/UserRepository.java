package com.PlayMarker.usermanage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Additional custom query methods if  needed
	
    User findByEmail(String email);
    void deleteByUsername(String username);
    User findByUsername(String username);
    boolean existsByUsername(String username);
	
}