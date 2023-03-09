package com.bptn.feedapp.controller;

import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;

import com.bptn.feedapp.jdbc.UserBean;
import com.bptn.feedapp.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import java.sql.Timestamp;
import java.time.Instant;

import com.bptn.feedapp.jpa.User;

import java.util.Optional;
@RestController
@RequestMapping("/user")
public class UserController {
	
	final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public List<User> listUsers() {
		logger.debug("The listUsers() method was invoked!");
		return this.userService.listUsers();
	}
	
	@GetMapping("/{username}")
	public Optional<User> findByUsername(@PathVariable String username) {
		logger.debug("The findByUsername() method was invoked!, username={}", username);
		return this.userService.findByUsername(username);
	}
	
	@GetMapping("/{first}/{last}/{username}/{password}/{phone}/{emailId}")
	public String createUser( @PathVariable String first, @PathVariable String last, @PathVariable String username, 
			@PathVariable String password, @PathVariable String phone, @PathVariable String emailId) {
		User user = new User();
		
		user.setFirstName(first);
		user.setLastName(last);
		user.setUsername(username);
		user.setPassword(password);
		user.setPhone(phone);
		user.setEmailId(emailId);
		user.setEmailVerified(false);
		user.setCreatedOn(Timestamp.from(Instant.now()));
				
		logger.debug("The createUser() method was invoked!, user={}", user.toString());
				
		this.userService.createUser(user);
				
		return "User Created Successfully";
		
}
	@GetMapping("/sign")
	public String testController() {
		logger.debug("The testController() method was invoked!");
		return "The FeedApp application is up and running";
	}
	@GetMapping("/signup")
	public String testController1() {
		logger.debug("The testController() 1 method was invoked!");
		return "Trigger test control 1";
	}
	@GetMapping("/forgot-password")
	public String testController2() {
		logger.debug("The testController() 2 method was invoked!");
		return "Trigger test control 2";
	}
	
}
