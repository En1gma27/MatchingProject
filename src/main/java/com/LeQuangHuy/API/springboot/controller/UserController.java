package com.LeQuangHuy.API.springboot.controller;

import com.LeQuangHuy.API.springboot.model.User;
import com.LeQuangHuy.API.springboot.security.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers(@RequestParam(required = false) String name) {
        if (name != null && !name.isEmpty()) {
            User user = userService.findByUsername(name).getBody();
            if (user != null) {
                return ResponseEntity.ok(List.of(user));
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            List<User> users = userService.getAllUsers();
            return ResponseEntity.ok(users);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        ResponseEntity<User> responseEntity = userService.updateUser(id, updatedUser);
        if (responseEntity != null && responseEntity.getBody() != null) {
            return ResponseEntity.ok(responseEntity.getBody());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
    }
}
