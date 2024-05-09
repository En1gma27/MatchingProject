package com.LeQuangHuy.API.springboot.service.Impl;
import com.LeQuangHuy.API.springboot.model.Character;
import com.LeQuangHuy.API.springboot.repository.CharacterRepository;

import com.LeQuangHuy.API.springboot.service.CharacterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor

public class CharacterServiceImpl implements CharacterService {



	private final CharacterRepository characterRepository;









	@Override
	public List<Character> getAllCharacter() {
		return characterRepository.findAll();
	}

	@Override
	public void deleteCharacterById(Long id) {
		characterRepository.deleteById(id);
	}
	@Override
	public Optional<Character> getCharacterById(Long id) {
		return characterRepository.findById(id);
	}

	@Override
	public List<Character> findBycharacterName(String character_name) {
		return (List<Character>) characterRepository.findBycharacterName(character_name);
	}

	@Override
	public Character saveCharacter(Character character) {
		// Thực hiện lưu hoặc cập nhật thông tin người dùng vào cơ sở dữ liệu
		return characterRepository.save(character);
	}

}
