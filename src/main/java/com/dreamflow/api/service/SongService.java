package com.dreamflow.api.service;
import com.dreamflow.api.dto.SongDTO;
import com.dreamflow.api.exception.ResourceNotFoundException;

import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface SongService {
	List<SongDTO> getSongs();
	SongDTO getSong(Long songId);
	ResponseEntity<Resource> streamSong(Long songId);
}
