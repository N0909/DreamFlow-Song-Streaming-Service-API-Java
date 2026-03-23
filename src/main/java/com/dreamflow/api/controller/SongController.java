package com.dreamflow.api.controller;
import java.util.List;
import java.util.Map;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import com.dreamflow.api.dto.SongDTO;
import com.dreamflow.api.entity.Song;
import com.dreamflow.api.service.*;

@RestController
@RequestMapping("/songs")
public class SongController {
	
	private final SongService service;
	
	public SongController(SongService service) {
		this.service = service;
	}
	
	@GetMapping("/")
	public ResponseEntity<List<SongDTO>> getSongs(){
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(service.getSongs());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<SongDTO> getSong(@PathVariable Long id) {
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(service.getSong(id));
	}
	
	@GetMapping("/{id}/stream")
	public ResponseEntity<Resource> getSongStream(@PathVariable Long id){
		return service.streamSong(id);
	}
}
