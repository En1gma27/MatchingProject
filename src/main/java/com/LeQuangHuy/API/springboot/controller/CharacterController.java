package com.LeQuangHuy.API.springboot.controller;

import com.LeQuangHuy.API.springboot.dto.CharacterDTO;
import com.LeQuangHuy.API.springboot.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    private final CharacterService characterService;

    @Autowired
    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping
    public List<CharacterDTO> getCharacters(@RequestParam(required = false) String characterName) {
        if (characterName != null && !characterName.isEmpty()) {
            return characterService.findByCharacterName(characterName);
        } else {
            return characterService.getAll();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CharacterDTO> updateCharacter(@PathVariable Long id, @RequestBody CharacterDTO updatedCharacterDTO) {
        CharacterDTO savedCharacterDTO = characterService.update(id, updatedCharacterDTO);
        if (savedCharacterDTO != null) {
            return ResponseEntity.ok(savedCharacterDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteCharacterById(@PathVariable Long id) {
        characterService.deleteById(id);
    }

    @PostMapping("/characters")
    public ResponseEntity<CharacterDTO> createCharacter(@RequestBody CharacterDTO characterDTO) {
        CharacterDTO savedCharacterDTO = characterService.save(characterDTO);
        return ResponseEntity.ok(savedCharacterDTO);
    }
}
