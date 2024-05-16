package com.LeQuangHuy.API.springboot.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CharacterDTO extends BaseDTO {
    private String characterName;
    private Long userId; // Thêm userId để tham chiếu đến người dùng liên quan
}
