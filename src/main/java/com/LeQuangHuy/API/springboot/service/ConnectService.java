package com.LeQuangHuy.API.springboot.service;
import com.LeQuangHuy.API.springboot.dto.CharacterDTO;
import com.LeQuangHuy.API.springboot.dto.ConnectDTO;
import java.util.List;
public interface ConnectService extends BaseService<ConnectDTO>  {



    List<ConnectDTO> findByUserId(Long userId);

    List<ConnectDTO> findByType(String type);

    List<ConnectDTO> findByUserIdAndType(Long userId, String type);

}
