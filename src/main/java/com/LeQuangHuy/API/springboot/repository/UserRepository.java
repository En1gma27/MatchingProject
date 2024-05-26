package com.LeQuangHuy.API.springboot.repository;

import com.LeQuangHuy.API.springboot.filter.UserFilter;
import com.LeQuangHuy.API.springboot.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT u FROM User u WHERE " +
			"(:username IS NULL OR u.username LIKE %:username%) " +
			"AND (:email IS NULL OR u.email LIKE %:email%) " +
			"AND (:address IS NULL OR u.address LIKE %:address%) " +
			"AND (:type IS NULL OR u.type = :type)")
	Page<User> findWithFilter(Pageable pageable,
							  @Param("username") String username,
							  @Param("email") String email,
							  @Param("address") String address,
							  @Param("type") String type);
	boolean existsByEmail(String email);
	boolean existsByUsername(String username);
}
