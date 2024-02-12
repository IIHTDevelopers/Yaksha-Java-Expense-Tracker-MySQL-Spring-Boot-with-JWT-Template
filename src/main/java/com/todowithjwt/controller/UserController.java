package com.todowithjwt.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todowithjwt.entity.AuthRequest;
import com.todowithjwt.entity.User;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class UserController {

	@PostMapping("/generateToken")
	public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
		// write your logic here
		return null;
	}

	@PostMapping("/addNewUser")
	public String addNewUser(@RequestBody @Valid User user) {
		// write your logic here
		return null;
	}
}