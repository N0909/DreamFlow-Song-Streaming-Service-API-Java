package com.dreamflow.api.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="users")
public class User {
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long userId;
	@Column(name="username", unique=true)
	private String userName;
	@Column(name="email", unique=true)
	private String email;
	@Column(name="password_hash")
	private String password;
	@Column(name="created_at")
	private LocalDateTime createdAt;
	
	public User() {}

	public User(long userId, String userName, String email, String password, LocalDateTime createdAt) {
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.createdAt = createdAt;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

}
