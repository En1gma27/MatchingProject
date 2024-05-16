package com.LeQuangHuy.API.springboot.repository;

import com.LeQuangHuy.API.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT u FROM User u WHERE u.username LIKE %:name%")
	List<User> findByUsername(@Param("name") String username);
	boolean existsByEmail(String email);

	boolean existsByUsername(String username);

}
