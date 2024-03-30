package com.PlayMarker.usermanagement;

import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Long> {
    // Additional custom query methods if  needed
}