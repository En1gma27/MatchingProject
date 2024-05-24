package com.LeQuangHuy.API.springboot.mapper;

import com.LeQuangHuy.API.springboot.dto.ConnectDTO;
import com.LeQuangHuy.API.springboot.dto.DemandDTO;
import com.LeQuangHuy.API.springboot.dto.FeedBackDTO;
import com.LeQuangHuy.API.springboot.model.Connect;
import com.LeQuangHuy.API.springboot.model.Demand;
import com.LeQuangHuy.API.springboot.model.FeedBack;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring")
public interface DemandMapper extends BaseMapper<Demand,DemandDTO>{

    @Override
    @Mapping(source = "user.id", target = "userId")
    DemandDTO entityToDTO(Demand demand);
    @Override
    Demand dtoToEntity(DemandDTO dto);
}
