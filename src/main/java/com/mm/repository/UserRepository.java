package com.mm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mm.domain.User;

public interface UserRepository extends JpaRepository<User, Long>  {
	
	@Query("SELECT u from User u WHERE u.username = ?1 AND u.password = ?2")
	User login(String username, String password);
}
