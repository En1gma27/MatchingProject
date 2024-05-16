package com.LeQuangHuy.API.springboot.dto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class FeedBackDTO extends BaseDTO
{
    private Long userId;
    private Long connectId;
    private Integer  rate;
    private String note;
}
