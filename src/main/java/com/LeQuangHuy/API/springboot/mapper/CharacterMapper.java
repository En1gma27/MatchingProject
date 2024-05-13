package com.LeQuangHuy.API.springboot.mapper;

import com.LeQuangHuy.API.springboot.dto.CharacterDTO;
import com.LeQuangHuy.API.springboot.model.Character;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CharacterMapper {

    @Mapping(source = "user.id", target = "userId")
    CharacterDTO characterToDTO(Character character);
    Character toEntity(CharacterDTO characterDTO);
}
