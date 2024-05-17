package com.LeQuangHuy.API.springboot.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DemandDTO extends BaseDTO{
    private Long userId;
    private String type;
    private String description;
}
