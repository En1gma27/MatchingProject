package com.LeQuangHuy.API.springboot.security.service;


import com.LeQuangHuy.API.springboot.service.UserValidationService;
import com.LeQuangHuy.API.springboot.model.User;
import com.LeQuangHuy.API.springboot.model.UserRole;
import com.LeQuangHuy.API.springboot.security.dto.AuthenticatedUserDto;
import com.LeQuangHuy.API.springboot.security.dto.RegistrationRequest;
import com.LeQuangHuy.API.springboot.security.dto.RegistrationResponse;
import com.LeQuangHuy.API.springboot.security.mapper.UserMapper;
import com.LeQuangHuy.API.springboot.utils.GeneralMessageAccessor;
import com.LeQuangHuy.API.springboot.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service


public class UserServiceImpl implements UserService {

	private static final String REGISTRATION_SUCCESSFUL = "registration_successful";

	private final UserRepository userRepository;

	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	private final UserValidationService userValidationService;

	private final GeneralMessageAccessor generalMessageAccessor;


	// Constructor
	public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, UserValidationService userValidationService, GeneralMessageAccessor generalMessageAccessor) {
		this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userValidationService = userValidationService;
        this.generalMessageAccessor = generalMessageAccessor;
    }



	@Override
	public RegistrationResponse registration(RegistrationRequest registrationRequest) {
		userValidationService.validateUser(registrationRequest);

		final User user = UserMapper.INSTANCE.convertToUser(registrationRequest);
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setUserRole(UserRole.USER);

		userRepository.save(user);

		final String username = registrationRequest.getUsername();
		final String registrationSuccessMessage = generalMessageAccessor.getMessage(null, REGISTRATION_SUCCESSFUL, username);

		log.info("{} registered successfully!", username);

		return new RegistrationResponse(registrationSuccessMessage);
	}

	@Override
	public AuthenticatedUserDto findAuthenticatedUserByUsername(String username) {
		final User user = findByUsername(username);
		return UserMapper.INSTANCE.convertToAuthenticatedUserDto(user);
	}

	@Override
	public List<User> getAllUsers() {

		return userRepository.findAll();
	}

	@Override
	public void deleteUserById(Long id) {

		userRepository.deleteById(id);
	}
	@Override
	public Optional<User> getUserById(Long id) {

		return userRepository.findById(id);
	}

	@Override
	public User findByUsername(String username) {

		return userRepository.findByUsername(username);
	}

	@Override
	public User saveUser(User user) {
		// Thực hiện lưu hoặc cập nhật thông tin người dùng vào cơ sở dữ liệu
		return userRepository.save(user);
	}



}
