package com.LeQuangHuy.API.springboot.mapper;

import com.LeQuangHuy.API.springboot.dto.CharacterDTO;
import com.LeQuangHuy.API.springboot.mapper.BaseMapper;
import com.LeQuangHuy.API.springboot.model.Character;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CharacterMapper extends BaseMapper<Character, CharacterDTO> {

    @Override
    @Mapping(source = "user.id", target = "userId")
    CharacterDTO entityToDTO(Character character);

    @Override
    Character dtoToEntity(CharacterDTO dto);
}
