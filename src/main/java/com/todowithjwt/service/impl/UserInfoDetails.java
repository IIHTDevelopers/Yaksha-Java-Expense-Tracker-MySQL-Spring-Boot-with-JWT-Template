package com.todowithjwt.service.impl;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.todowithjwt.entity.User;

public class UserInfoDetails implements UserDetails {

	public UserInfoDetails(User user) {
		// write your logic here
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// write your logic here
		return null;
	}

	@Override
	public String getPassword() {
		// write your logic here
		return null;
	}

	@Override
	public String getUsername() {
		// write your logic here
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// write your logic here
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// write your logic here
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// write your logic here
		return false;
	}

	@Override
	public boolean isEnabled() {
		// write your logic here
		return false;
	}
}