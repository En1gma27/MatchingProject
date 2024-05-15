package com.LeQuangHuy.API.springboot.service.Impl;

import com.LeQuangHuy.API.springboot.dto.ConnectDTO;
import com.LeQuangHuy.API.springboot.mapper.ConnectMapper;
import com.LeQuangHuy.API.springboot.model.Connect;
import com.LeQuangHuy.API.springboot.repository.ConnectRepository;
import com.LeQuangHuy.API.springboot.service.ConnectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConnectServiceImpl implements ConnectService {

    private final ConnectRepository connectRepository;
    private final ConnectMapper connectMapper;

    @Autowired
    public ConnectServiceImpl(ConnectRepository connectRepository, ConnectMapper connectMapper) {
        this.connectRepository= connectRepository;
        this.connectMapper = connectMapper;
    }

    @Override
    public List<ConnectDTO> getAllConnect() {
        List<Connect> connects = connectRepository.findAll();
        return connects.stream().map(connectMapper::connectToDTO ).collect(Collectors.toList());
    }

    @Override
    public List<ConnectDTO> findByUserId(Long userId) {
        List<Connect> connects = connectRepository.findByUserId(userId);
        return connects.stream().map(connectMapper::connectToDTO).collect(Collectors.toList());
    }

    @Override
    public List<ConnectDTO> findByType(String type) {
        return connectRepository.findByType(type).stream()
                .map(connectMapper::connectToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ConnectDTO> findByUserIdAndType(Long userId, String type) {
        return connectRepository.findByUserIdAndType(userId,type).stream()
                .map(connectMapper::connectToDTO)
                .collect(Collectors.toList());
    }
    @Override

    public ConnectDTO updateConnect(Long id, ConnectDTO updatedConnectDTO) {
        return null;
    }

    @Override
    public void deleteConnectById(Long id) {
        connectRepository.deleteById(id);
    }

    @Override
    public ConnectDTO saveConnect(ConnectDTO connectDTO) {
        Connect connectToSave = connectMapper.toEntity(connectDTO);
        Connect savedConnect = connectRepository.save(connectToSave);
        return connectMapper.connectToDTO(savedConnect);
    }
}
