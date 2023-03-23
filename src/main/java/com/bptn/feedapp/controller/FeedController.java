package com.bptn.feedapp.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import com.bptn.feedapp.service.FeedService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.bptn.feedapp.jpa.Feed;

@CrossOrigin
@RestController
@RequestMapping("/feeds")
public class FeedController {
	
	final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
	FeedService feedService;
	
	@PostMapping
	public Feed createFeed(@RequestBody Feed feed) {
				
		logger.debug("Creating Feed");
				
		return this.feedService.createFeed(feed);
	}
}
