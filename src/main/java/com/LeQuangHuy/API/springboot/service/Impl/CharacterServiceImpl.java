package com.LeQuangHuy.API.springboot.service.Impl;

import com.LeQuangHuy.API.springboot.dto.CharacterDTO;
import com.LeQuangHuy.API.springboot.dto.ConnectDTO;
import com.LeQuangHuy.API.springboot.mapper.CharacterMapper;
import com.LeQuangHuy.API.springboot.model.Character;
import com.LeQuangHuy.API.springboot.model.Connect;
import com.LeQuangHuy.API.springboot.repository.CharacterRepository;
import com.LeQuangHuy.API.springboot.service.CharacterService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterServiceImpl implements CharacterService {

    private final CharacterRepository characterRepository;
    private final CharacterMapper characterMapper;

    @Autowired
    public CharacterServiceImpl(CharacterRepository characterRepository, CharacterMapper characterMapper) {
        this.characterRepository = characterRepository;
        this.characterMapper = characterMapper;
    }

    @Override
    public Page<CharacterDTO> findWithFilter(Pageable pageable,
                                           Long userId,
                                           String characterName) {
        Page<Character> pageResult = characterRepository.findWithFilter(pageable,characterName,userId);
        return pageResult.map(characterMapper::entityToDTO);
    }

    @Override
    public List<CharacterDTO> getAll() {
        List<Character> characters = characterRepository.findAll();
        return characters.stream().map(characterMapper::entityToDTO).collect(Collectors.toList());
    }

    @Override
    public CharacterDTO findById(Long id) {
        return null;
    }


    @Override
    public CharacterDTO update(Long id, CharacterDTO updatedCharacterDTO) {
        Character existingCharacter = characterRepository.findById(id).orElse(null);
        if (existingCharacter != null) {
            existingCharacter.setCharacterName(updatedCharacterDTO.getCharacterName());
            Character savedCharacter = characterRepository.save(existingCharacter);
            return characterMapper.entityToDTO(savedCharacter);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        characterRepository.deleteById(id);
    }

    @Override
    public CharacterDTO save(CharacterDTO characterDTO) {
        Character characterToSave = characterMapper.dtoToEntity(characterDTO);
        Character savedCharacter = characterRepository.save(characterToSave);
        return characterMapper.entityToDTO(savedCharacter);
    }
}
