package com.LeQuangHuy.API.springboot.security.dto;

import com.LeQuangHuy.API.springboot.model.UserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class AuthenticatedUserDto {

	private String Address;

	private String username;

	private String password;

	private UserRole userRole;

}
