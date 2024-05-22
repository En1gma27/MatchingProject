package com.LeQuangHuy.API.springboot.service;
import com.LeQuangHuy.API.springboot.dto.CharacterDTO;
import com.LeQuangHuy.API.springboot.filter.CharacterFilter;
import com.LeQuangHuy.API.springboot.model.Character;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CharacterService extends BaseService<CharacterDTO, CharacterFilter, Character, Long> {

    Page<CharacterDTO> findWithFilter(Pageable pageable, Long userId, String characterName);

}
