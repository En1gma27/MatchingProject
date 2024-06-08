package com.LeQuangHuy.API.springboot.controller;

import com.LeQuangHuy.API.springboot.dto.ConnectDTO;
import com.LeQuangHuy.API.springboot.dto.FeedBackDTO;
import com.LeQuangHuy.API.springboot.dto.UserDTO;
import com.LeQuangHuy.API.springboot.filter.UserFilter;
import com.LeQuangHuy.API.springboot.model.User;
import com.LeQuangHuy.API.springboot.security.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController extends BaseController<UserDTO, UserFilter, User, Long> {

    private final UserService userService;

    public UserController(UserService userService) {
        super(userService);
        this.userService = userService;
    }
    @GetMapping
    public Page<UserDTO> getUsers(
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) String type,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        if ( username != null || email != null || address != null || type != null) {
            return userService.findWithFilter(pageable,username,email,address,type);
        } else {
            List<UserDTO> allUsers = userService.getAll();
            return new PageImpl<>(allUsers, pageable, allUsers.size());
        }
    }

}
