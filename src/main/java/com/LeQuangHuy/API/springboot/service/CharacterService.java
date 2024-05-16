package com.LeQuangHuy.API.springboot.service;

import com.LeQuangHuy.API.springboot.dto.CharacterDTO;

import java.util.List;

public interface CharacterService extends BaseService<CharacterDTO> {
	List<CharacterDTO> findByCharacterName(String characterName);
}
