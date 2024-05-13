package com.LeQuangHuy.API.springboot.service;

import com.LeQuangHuy.API.springboot.dto.CharacterDTO;

import java.util.List;

public interface CharacterService {

	List<CharacterDTO> getAllCharacters();

	List<CharacterDTO> findByCharacterName(String characterName);

	CharacterDTO updateCharacter(Long id, CharacterDTO updatedCharacterDTO);

	void deleteCharacterById(Long id);

	CharacterDTO saveCharacter(CharacterDTO characterDTO);
}
