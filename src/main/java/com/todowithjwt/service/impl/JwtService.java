package com.todowithjwt.service.impl;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;

@Component
public class JwtService {

	public static final String SECRET = "5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";

	public String generateToken(String userName) {
		// write your logic here
		return null;
	}

	private String createToken(Map<String, Object> claims, String userName) {
		// write your logic here
		return null;
	}

	private Key getSignKey() {
		// write your logic here
		return null;
	}

	public String extractUsername(String token) {
		// write your logic here
		return null;
	}

	public Date extractExpiration(String token) {
		// write your logic here
		return null;
	}

	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		// write your logic here
		return null;
	}

	private Claims extractAllClaims(String token) {
		// write your logic here
		return null;
	}

	private Boolean isTokenExpired(String token) {
		// write your logic here
		return null;
	}

	public Boolean validateToken(String token, UserDetails userDetails) {
		// write your logic here
		return null;
	}
}