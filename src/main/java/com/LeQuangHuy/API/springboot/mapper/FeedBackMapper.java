package com.LeQuangHuy.API.springboot.mapper;

import com.LeQuangHuy.API.springboot.dto.ConnectDTO;
import com.LeQuangHuy.API.springboot.dto.FeedBackDTO;
import com.LeQuangHuy.API.springboot.model.Connect;
import com.LeQuangHuy.API.springboot.model.FeedBack;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FeedBackMapper extends BaseMapper<FeedBack, FeedBackDTO> {

    @Override
    @Mapping(source = "user.id", target = "userId")
    FeedBackDTO entityToDTO(FeedBack feedBack);

    @Override
    FeedBack dtoToEntity(FeedBackDTO dto);
}
