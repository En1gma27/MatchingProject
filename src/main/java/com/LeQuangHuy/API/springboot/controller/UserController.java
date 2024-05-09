package com.LeQuangHuy.API.springboot.controller;


import com.LeQuangHuy.API.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.LeQuangHuy.API.springboot.security.service.UserService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {

        this.userService = userService;
    }
    @GetMapping
    public ResponseEntity<?> getUsers(@RequestParam(required = false) String name) {
        if (name != null && !name.isEmpty()) {
            User user = userService.findByUsername(name);
            if (user != null) {
                return ResponseEntity.ok(Collections.singletonList(user));
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.ok(userService.getAllUsers());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        // Call the service method to update the User
        Optional<User> existingUserOptional = userService.getUserById(id);
        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setUserRole(updatedUser.getUserRole());
            existingUser.setAddress(updatedUser.getAddress());
            User savedUser = userService.saveUser(existingUser);
            return ResponseEntity.ok(savedUser);
        } else {

            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
    }
}
