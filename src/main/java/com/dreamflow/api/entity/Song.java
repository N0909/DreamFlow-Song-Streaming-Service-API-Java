package com.dreamflow.api.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;

@Entity
@Table(name="songs")
public class Song {
	@Id
	@Column(name="song_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long songId;
	@Column(name="song_name")
	private String songName;
	@Column(name="song_path")
	private String songPath;
	@Column(name="duration_seconds")
	private int durationSeconds;
	@Column(name="created_at")
	private LocalDateTime createdAt;
	
	public Song() {}
	
	public Song(long songId, String songName, String songPath, int durationSeconds, LocalDateTime createdAt) {
		this.songId = songId;
		this.songName = songName;
		this.songPath = songPath;
		this.durationSeconds = durationSeconds;
		this.createdAt = createdAt;
	}
	

	public long getSongId() {
		return songId;
	}

	public void setSongId(long songId) {
		this.songId = songId;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getSongPath() {
		return songPath;
	}

	public void setSongPath(String songPath) {
		this.songPath = songPath;
	}

	public int getDurationSeconds() {
		return durationSeconds;
	}

	public void setDurationSeconds(int durationSeconds) {
		this.durationSeconds = durationSeconds;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	
}
