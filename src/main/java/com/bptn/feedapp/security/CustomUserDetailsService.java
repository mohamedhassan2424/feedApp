package com.bptn.feedapp.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;
import com.bptn.feedapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import com.bptn.feedapp.jpa.User;
import java.util.Optional;

@Service("UserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<User> opt = this.userRepository.findByUsername(username);

		if (opt.isEmpty()) {
			throw new UsernameNotFoundException("Username not found: " + username);
		}

		return new CustomUserDetails(opt.get());
	}
	
	@Autowired
	UserRepository userRepository;
}
