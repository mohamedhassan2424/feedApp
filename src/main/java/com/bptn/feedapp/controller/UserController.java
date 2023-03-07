package com.bptn.feedapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/user")
public class UserController {
	
	final Logger logger = LoggerFactory.getLogger(this.getClass());
	
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
