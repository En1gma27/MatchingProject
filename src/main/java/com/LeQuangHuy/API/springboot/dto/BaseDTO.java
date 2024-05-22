package com.LeQuangHuy.API.springboot.dto;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
@Getter
@Setter
public class BaseDTO {
    private Long id;
    private Instant createdAt;
    private Instant updatedAt;
}
