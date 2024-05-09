package com.LeQuangHuy.API.springboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "characters")
public class Character {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;



	@JsonProperty("character_name") // Xác định tên trường trong JSON trả về
	private String characterName;

	@JsonProperty("UserID") // Xác định tên trường trong JSON trả về
	private String user_id;

	@JsonIgnore // Không xuất hiện trong response body
	@Column(name = "created_at")
	private LocalDateTime createdAt;

	// Phương thức PrePersist để tự động cập nhật createdAt trước khi lưu vào cơ sở dữ liệu
	@PrePersist
	protected void onCreate() {
		createdAt = LocalDateTime.now();
	}

	@JsonIgnore // Không xuất hiện trong response body
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;


}
