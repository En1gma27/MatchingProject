package com.LeQuangHuy.API.springboot.controller;

import com.LeQuangHuy.API.springboot.model.Character;
import com.LeQuangHuy.API.springboot.model.User;
import com.LeQuangHuy.API.springboot.security.service.UserService;
import com.LeQuangHuy.API.springboot.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    @Autowired
    private CharacterService characterService;
    private UserService userService;
    public CharacterController(CharacterService characterService,UserService userService) {

        this.characterService = characterService;
        this.userService = userService;
    }
    @GetMapping
    public List<Character> getCharacter(@RequestParam(required = false) String character_name) {
        if (character_name != null && !character_name.isEmpty()) {
            return characterService.findBycharacterName(character_name);
        } else {
            return characterService.getAllCharacter();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Character> updateBook(@PathVariable Long id, @RequestBody Character updatedCharacter) {
        // goi service method de ypdate User
        Optional<Character> existingCharacterOptional = characterService.getCharacterById(id);
        if (existingCharacterOptional.isPresent()) {
            Character existingCharacter = existingCharacterOptional.get();
            existingCharacter.setCharacterName(updatedCharacter.getCharacterName());
            Character savedCharacter = characterService.saveCharacter(existingCharacter);
            return ResponseEntity.ok(savedCharacter);
        } else {

            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id) {
        characterService.deleteCharacterById(id);
    }

    @PostMapping("/characters")
    public ResponseEntity<Character> createCharacter(@RequestParam Long id,
                                                     @RequestParam String characterName,
                                                     @RequestParam Long userId) {
        // Tạo một đối tượng Character mới
        Character character = new Character();
        character.setId(id);
        character.setCharacterName(characterName);

        // Lấy thông tin User từ userId
        Optional<User> userOptional = userService.getUserById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();

            // Liên kết character với user
            character.setUser(user);

            // Lưu Character vào cơ sở dữ liệu
            Character savedCharacter = characterService.saveCharacter(character);

            // Trả về Character đã lưu trong phản hồi
            return ResponseEntity.ok(savedCharacter);
        } else {
            // Nếu không tìm thấy user, trả về ResponseEntity.notFound()
            return ResponseEntity.notFound().build();
        }
    }
}
