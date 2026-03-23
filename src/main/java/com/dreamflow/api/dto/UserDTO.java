package com.dreamflow.api.dto;
import java.time.LocalDateTime;

public record UserDTO(long id, String userName, String userEmail, LocalDateTime createdAt) {}
