package com.LeQuangHuy.API.springboot.security.service;

import com.LeQuangHuy.API.springboot.model.User;
import com.LeQuangHuy.API.springboot.security.dto.AuthenticatedUserDto;
import com.LeQuangHuy.API.springboot.security.dto.RegistrationRequest;
import com.LeQuangHuy.API.springboot.security.dto.RegistrationResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
	Optional<User> getUserById(Long id);
	ResponseEntity<User> findByUsername(String username);
	RegistrationResponse registration(RegistrationRequest registrationRequest);
	AuthenticatedUserDto findAuthenticatedUserByUsername(String username);
	List<User> getAllUsers();
	void deleteUserById(Long id);
	User saveUser(User user);
	ResponseEntity<User> updateUser(Long id, User user);
}
