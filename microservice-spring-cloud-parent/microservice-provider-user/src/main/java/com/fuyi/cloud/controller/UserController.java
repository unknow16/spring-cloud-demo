package com.fuyi.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fuyi.cloud.entity.User;
import com.fuyi.cloud.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/simple/{id}")
	public User findById(@PathVariable Long id){
		User user = userRepository.findOne(id);
		return user;
	}
	
}
