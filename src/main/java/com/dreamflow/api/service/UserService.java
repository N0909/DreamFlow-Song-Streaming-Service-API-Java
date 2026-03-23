package com.dreamflow.api.service;
import com.dreamflow.api.auth.SignUpDTO;
import com.dreamflow.api.dto.UserDTO;
import  com.dreamflow.api.entity.User;

public interface UserService {
	public UserDTO getUser(String username);
	public UserDTO addUser(SignUpDTO user);
}
