package com.todowithjwt.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.todowithjwt.entity.User;

@Service
public class UserInfoService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// write your logic here
		return null;
	}

	public String addUser(User user) {
		// write your logic here
		return null;
	}
}