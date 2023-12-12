package com.springboot.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.blog.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	
//	 custome query to load the role detailes from the database for database authentication 
	 Optional<User> findByEmail(String email);
	 
	 Optional<User> findByuserNameOrEmail(String name, String email);
	 
	 
	 Optional<User> findByUserName(String userName);
	 
	 Boolean existsByUserName(String userName);
	 
	 Boolean existsByEmail(String Email);
}
