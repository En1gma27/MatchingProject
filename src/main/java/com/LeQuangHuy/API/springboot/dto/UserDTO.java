package com.LeQuangHuy.API.springboot.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO extends  BaseDTO
{
    private String username;
    private String password;
    private String email;
    private String address;
    private String type;
}
