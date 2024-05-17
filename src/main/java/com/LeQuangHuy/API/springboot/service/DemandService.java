package com.LeQuangHuy.API.springboot.service;
import com.LeQuangHuy.API.springboot.dto.CharacterDTO;
import com.LeQuangHuy.API.springboot.dto.ConnectDTO;
import com.LeQuangHuy.API.springboot.dto.DemandDTO;

import java.util.List;
public interface DemandService extends BaseService<DemandDTO>  {



    List<DemandDTO> findByUserId(Long userId);

    List<DemandDTO> findByDemandType(String type );

    List<DemandDTO> findByUserIdAndDemandType(Long userId, String type);

}
