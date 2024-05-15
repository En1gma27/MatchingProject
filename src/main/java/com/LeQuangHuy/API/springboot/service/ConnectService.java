package com.LeQuangHuy.API.springboot.service;
import com.LeQuangHuy.API.springboot.dto.ConnectDTO;
import java.util.List;
public interface ConnectService {

    List<ConnectDTO> getAllConnect();

    List<ConnectDTO> findByUserId(Long userId);

    List<ConnectDTO> findByType(String type);

    List<ConnectDTO> findByUserIdAndType(Long userId, String type);

    ConnectDTO updateConnect(Long id, ConnectDTO updatedConnectDTO);


    void deleteConnectById(Long id);

    ConnectDTO saveConnect(ConnectDTO connectDTO);
}
