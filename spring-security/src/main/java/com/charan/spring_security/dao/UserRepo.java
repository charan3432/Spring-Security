package com.charan.spring_security.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.charan.spring_security.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	
	User findByUsername(String username);
}
