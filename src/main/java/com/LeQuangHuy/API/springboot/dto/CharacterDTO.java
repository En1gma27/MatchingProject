package com.LeQuangHuy.API.springboot.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterDTO {
    private Long id;
    private String characterName;
    private Long userId; // Thêm userId để tham chiếu đến người dùng liên quan
}
