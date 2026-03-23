package com.dreamflow.api.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dreamflow.api.dto.UserDTO;
import com.dreamflow.api.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private final UserService service;
	
	public UserController(UserService service) {
		this.service = service;
	}
	
	@GetMapping("/me")
	public ResponseEntity<UserDTO> getUser(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(service.getUser(auth.getName()));
	}
		
}
