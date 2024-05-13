package com.LeQuangHuy.API.springboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
	@JsonIgnore // Không xuất hiện trong request body
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonProperty("user_name")
	@Column(unique = true)
	private String username;


	@JsonProperty("password")
	private String password;

	@JsonProperty("email")
	private String email;


	@JsonProperty("address")
	private String address;


	@JsonProperty("userRole")
	@Enumerated(EnumType.STRING)
	private UserRole userRole;

	@JsonIgnore
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Character> characters = new ArrayList<>();

	@JsonIgnore // Không xuất hiện trong request body
	@Column(name = "created_at")
	private LocalDateTime createdAt;
	// Phương thức PrePersist để tự động cập nhật createdAt trước khi lưu vào cơ sở dữ liệu

	@PrePersist
	protected void onCreate() {
		createdAt = LocalDateTime.now();
	}
	@JsonIgnore // Không xuất hiện trong request body
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;



}
