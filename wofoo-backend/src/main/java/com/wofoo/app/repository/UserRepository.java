package com.wofoo.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wofoo.app.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	Optional<User> findByName(String name);

}
