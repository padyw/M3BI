package com.pramod.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pramod.entity.User;
import com.pramod.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository; 
	public User saveUser(User user) {
		return userRepository.save(user);
	}

}
