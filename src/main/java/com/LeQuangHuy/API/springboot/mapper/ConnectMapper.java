package com.LeQuangHuy.API.springboot.mapper;

import com.LeQuangHuy.API.springboot.dto.CharacterDTO;
import com.LeQuangHuy.API.springboot.model.Character;
import com.LeQuangHuy.API.springboot.model.Connect;
import com.LeQuangHuy.API.springboot.dto.ConnectDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ConnectMapper extends BaseMapper<Connect, ConnectDTO> {

    @Override
    @Mapping(source = "user.id", target = "userId")
    ConnectDTO entityToDTO(Connect connect);

    @Override
    Connect dtoToEntity(ConnectDTO dto);
}

