package com.LeQuangHuy.API.springboot.security.service;

import com.LeQuangHuy.API.springboot.model.User;
import com.LeQuangHuy.API.springboot.repository.UserRepository;
import com.LeQuangHuy.API.springboot.security.dto.AuthenticatedUserDto;
import com.LeQuangHuy.API.springboot.security.dto.RegistrationRequest;
import com.LeQuangHuy.API.springboot.security.dto.RegistrationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public Optional<User> getUserById(Long id) {
		return Optional.empty();
	}

	@Override
	public ResponseEntity<User> findByUsername(String username) {
		User user = userRepository.findByUsername(username);
		if (user != null) {
			return ResponseEntity.ok(user);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@Override
	public RegistrationResponse registration(RegistrationRequest registrationRequest) {
		return null;
	}

	@Override
	public AuthenticatedUserDto findAuthenticatedUserByUsername(String username) {
		return null;
	}

	@Override
	public ResponseEntity<User> updateUser(Long id, User updatedUser) {


        Optional<User> existingUserOptional = userRepository.findById(id);
        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();
			existingUser.setEmail(updatedUser.getEmail());
			existingUser.setUsername(updatedUser.getUsername());
			existingUser.setUserRole(updatedUser.getUserRole());
			existingUser.setAddress(updatedUser.getAddress());
			existingUser.setType(updatedUser.getType());
			User savedUser = userRepository.save(existingUser);
            return ResponseEntity.ok(savedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
	}
	@Override
	public void deleteUserById(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public User saveUser(User user) {
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
}
