//package com.LeQuangHuy.API.springboot.model;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
//
//@Getter
//@Setter
//@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//@Table(name = "connects")
//public class Connect {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//
//
//    @JsonProperty("type") // Xác định tên trường trong JSON trả về
//    private String type;
//
//    @JsonProperty("status") // Xác định tên trường trong JSON trả về
//    private String status;
//
//    @JsonProperty("group_name") // Xác định tên trường trong JSON trả về
//    private String group_name;
//
//
//	@JsonIgnore
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "user_id1")
//	private User user1;
//
//	@JsonIgnore
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "user_id2")
//	private User user2;
//
//	@JsonIgnore // Không xuất hiện trong response body
//	@Column(name = "created_at")
//	private LocalDateTime createdAt;
//
//	// Phương thức PrePersist để tự động cập nhật createdAt trước khi lưu vào cơ sở dữ liệu
//	@PrePersist
//	protected void onCreate() {
//		createdAt = LocalDateTime.now();
//	}
//
//	@JsonIgnore // Không xuất hiện trong response body
//	@Column(name = "updated_at")
//	private LocalDateTime updatedAt;
//
//}
