package com.wofoo.app.service;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

import com.wofoo.app.entity.User;
import com.wofoo.app.repository.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepo;
	
	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	public User saveUser(User user) {
		if(user.get_name() == null || user.get_name().trim().isEmpty()) {
			throw new IllegalArgumentException("Name must not be empty");
		}
		return userRepo.save(user);
	}

	public List<User> getAllUsers() {
		return userRepo.findAll();
	}
	
	public User findUserByName(String name) {
		return userRepo.findByName(name).orElseThrow(NoSuchElementException::new);
	}
}
	
	


