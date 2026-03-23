package com.dreamflow.api.exception;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
public record ErrorResponse(String message) {}
