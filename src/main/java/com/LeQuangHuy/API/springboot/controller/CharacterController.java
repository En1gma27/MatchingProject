package com.LeQuangHuy.API.springboot.controller;

import com.LeQuangHuy.API.springboot.model.Character;
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

    public CharacterController(CharacterService characterService) {

        this.characterService = characterService;
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
        // Call the service method to update the User
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
                                                     @RequestParam String userId) {
        // Tạo một đối tượng Character mới
        Character character = new Character();
        character.setId(id);
        character.setCharacterName(characterName);
        character.setUser_id(userId);

        // Lưu Character vào cơ sở dữ liệu
        Character savedCharacter = characterService.saveCharacter(character);

        // Trả về Character đã lưu trong phản hồi
        return ResponseEntity.ok(savedCharacter);
    }
}
