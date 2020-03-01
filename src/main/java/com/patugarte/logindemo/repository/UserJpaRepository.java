package com.patugarte.logindemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patugarte.logindemo.model.User;

public interface UserJpaRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);
}
