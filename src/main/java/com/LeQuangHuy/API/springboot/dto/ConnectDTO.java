package com.LeQuangHuy.API.springboot.dto;

import com.LeQuangHuy.API.springboot.model.Connect;
import lombok.Getter;
import lombok.Setter;
import org.mapstruct.Mapper;

// ConnectDTO.java
@Getter
@Setter
public class ConnectDTO extends BaseDTO {
    private String type;
    private String status;
    private String groupName;
    private Long userId;
    private Long userId2;


}
