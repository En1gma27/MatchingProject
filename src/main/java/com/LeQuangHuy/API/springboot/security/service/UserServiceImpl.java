
package com.LeQuangHuy.API.springboot.security.service;

import com.LeQuangHuy.API.springboot.dto.DemandDTO;
import com.LeQuangHuy.API.springboot.dto.UserDTO;
import com.LeQuangHuy.API.springboot.filter.UserFilter;
import com.LeQuangHuy.API.springboot.model.Demand;
import com.LeQuangHuy.API.springboot.model.User;
import com.LeQuangHuy.API.springboot.repository.UserRepository;
import com.LeQuangHuy.API.springboot.security.dto.AuthenticatedUserDto;
import com.LeQuangHuy.API.springboot.security.dto.RegistrationRequest;
import com.LeQuangHuy.API.springboot.security.dto.RegistrationResponse;
import com.LeQuangHuy.API.springboot.security.mapper.UserMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final UserMapper userMapper;
	public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
		this.userRepository = userRepository;
        this.userMapper = userMapper;
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
	public Page<UserDTO> findWithFilter(Pageable pageable,  String username, String email,String address,String type) {
		Page<User> pageResult = userRepository.findWithFilter(pageable,username,email,address,type);
		return pageResult.map(userMapper::entityToDTO);
	}

	@Override
	public List<UserDTO> getAll() {
		List<User> users = userRepository.findAll();
		return users.stream().map(userMapper::entityToDTO).collect(Collectors.toList());
	}

	@Override
	public UserDTO findById(Long id) {
		User user = userRepository.findById(id).orElse(null);
		return user != null ? userMapper.entityToDTO(user) : null;
	}

	@Override
	public UserDTO update(Long id, UserDTO updatedUserDTO) {
		User existingUser = userRepository.findById(id).orElse(null);
		if (existingUser != null) {
			existingUser.setUsername(updatedUserDTO.getUsername());
			existingUser.setPassword(updatedUserDTO.getPassword());
			existingUser.setEmail(updatedUserDTO.getEmail());
			existingUser.setAddress(updatedUserDTO.getAddress());
			existingUser.setType(updatedUserDTO.getType());
			User savedUser = userRepository.save(existingUser);
			return userMapper.entityToDTO(savedUser);
		} else {
			return null;
		}
	}

	@Override
	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public UserDTO save(UserDTO userDTO) {
		User userToSave = userMapper.dtoToEntity(userDTO);
		User savedUser = userRepository.save(userToSave);
		return userMapper.entityToDTO(savedUser);
	}
}
