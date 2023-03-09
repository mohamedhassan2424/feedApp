package com.bptn.feedapp.service;

import org.springframework.stereotype.Service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.bptn.feedapp.jdbc.UserDao;

import com.bptn.feedapp.jdbc.UserBean;

import com.bptn.feedapp.repository.UserRepository;

import com.bptn.feedapp.jpa.User;

import java.util.Optional;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public List<User> listUsers() {
		
//		return this.userDao.listUsers();
		return this.userRepository.findAll();
	}
	
	public Optional<User> findByUsername(String username) {
//		return this.userDao.findByUsername(username);
		return this.userRepository.findByUsername(username);
	}
	
	public void createUser(User user) {
//		this.userDao.createUser(user);
		this.userRepository.save(user);
	}
}
