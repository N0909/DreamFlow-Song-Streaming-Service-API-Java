package com.dreamflow.api.auth;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.dreamflow.api.dto.UserDTO;
import com.dreamflow.api.service.UserService;

@RequestMapping("/auth")
@RestController
public class AuthController {
	private final UserService userService;
	
	public AuthController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/sign-up") 
	public ResponseEntity<UserDTO> signup(@RequestBody SignUpDTO user){
		return ResponseEntity
				.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(userService.addUser(user));
	}
}
