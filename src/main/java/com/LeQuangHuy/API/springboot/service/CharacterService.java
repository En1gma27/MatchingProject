package com.LeQuangHuy.API.springboot.service;

import com.LeQuangHuy.API.springboot.model.Character;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CharacterService {

    Optional<Character> getCharacterById(Long id);

	List<Character> findBycharacterName(String character_name );



	List<Character> getAllCharacter();

	void deleteCharacterById(Long id);

	Character saveCharacter(Character character);



}
