package com.dreamflow.api.service.implementation;
import com.dreamflow.api.dto.SongDTO;
import com.dreamflow.api.entity.Song;
import com.dreamflow.api.exception.ResourceNotFoundException;
import com.dreamflow.api.repository.SongRepository;
import com.dreamflow.api.service.SongService;

import java.util.List;
import java.io.*;

import org.springframework.context.annotation.Primary;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Primary
@Component
public class SongServiceImpl implements SongService{
	
	private final SongRepository songRepository;
	
	public SongServiceImpl(SongRepository songRepository) {
		this.songRepository = songRepository;
	}
	
	@Override
	public List<SongDTO> getSongs(){
		List<SongDTO> songsDTO = songRepository.findAll()
								.stream()
								.map((song)->new SongDTO(
										song.getSongId(),
										song.getSongName(),
										song.getDurationSeconds(), 
										song.getCreatedAt())
								).toList();
		return songsDTO;
	}
	
	@Override
	public SongDTO getSong(Long songId){
		Song song = songRepository
					.findById(songId)
					.orElseThrow(()->new ResourceNotFoundException("Song With id "+songId+" Not found"));
		
		SongDTO songDTO = new SongDTO(
				song.getSongId(),
				song.getSongName(),
				song.getDurationSeconds(),
				song.getCreatedAt());
		
		return songDTO;
	}
	
	@Override
	public ResponseEntity<Resource> streamSong(Long songId) {
		Song song = songRepository.findById(songId)
								  .orElseThrow(()->
								  new ResourceNotFoundException("Song With id"
								  		+ " "+songId+" Not found"));
		
		File songFile = new File(song.getSongPath());
		
		InputStreamResource resource = null;
		
		try{			
			resource = new InputStreamResource(new FileInputStream(songFile));
			
		}catch(FileNotFoundException exception) {
			throw new ResourceNotFoundException("Internal Error or Resource Not Found");
		}
		
		return ResponseEntity
				.status(HttpStatus.PARTIAL_CONTENT)
				.header("Content-Type", "audio/mp3")
				.body(resource);
	}
	
}
