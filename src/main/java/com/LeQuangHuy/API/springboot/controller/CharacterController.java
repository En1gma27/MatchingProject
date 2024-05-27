package com.LeQuangHuy.API.springboot.controller;

import com.LeQuangHuy.API.springboot.dto.CharacterDTO;
import com.LeQuangHuy.API.springboot.filter.CharacterFilter;
import com.LeQuangHuy.API.springboot.model.Character; // Thay đổi ở đây
import com.LeQuangHuy.API.springboot.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/characters")
public class CharacterController extends BaseController<CharacterDTO, CharacterFilter, Character, Long> { // Thay đổi ở đây

    private final CharacterService characterService;

    @Autowired
    public CharacterController(CharacterService characterService) {
        super(characterService);
        this.characterService = characterService;
    }

    @GetMapping
    public Page<CharacterDTO> getCharacters(
            @RequestParam(required = false) Long userId,
            @RequestParam(required = false) String characterName,
            Pageable pageable) {
        if (userId != null || characterName != null) {
            return characterService.findWithFilter(pageable, userId, characterName);
        } else {
            List<CharacterDTO> allCharacters = characterService.getAll();
            return new PageImpl<>(allCharacters, pageable, allCharacters.size());
        }
    }

}
