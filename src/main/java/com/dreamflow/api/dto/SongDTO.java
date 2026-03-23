package com.dreamflow.api.dto;
import java.time.LocalDateTime;

public record SongDTO(long songId, String songName, int durationSeconds, LocalDateTime createdAt) {}
