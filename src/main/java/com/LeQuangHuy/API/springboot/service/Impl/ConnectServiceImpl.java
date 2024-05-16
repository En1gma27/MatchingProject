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
    public List<ConnectDTO> getAll() {
        List<Connect> connects = connectRepository.findAll();
        return connects.stream().map(connectMapper::entityToDTO ).collect(Collectors.toList());
    }

    @Override
    public ConnectDTO findById(Long id) {
        return null;
    }

    @Override
    public ConnectDTO update(Long id, ConnectDTO updatedDTO) {
        return null;
    }

    @Override
    public List<ConnectDTO> findByUserId(Long userId) {
        List<Connect> connects = connectRepository.findByUserId(userId);
        return connects.stream().map(connectMapper::entityToDTO).collect(Collectors.toList());
    }

    @Override
    public List<ConnectDTO> findByType(String type) {
        return connectRepository.findByType(type).stream()
                .map(connectMapper::entityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ConnectDTO> findByUserIdAndType(Long userId, String type) {
        return connectRepository.findByUserIdAndType(userId,type).stream()
                .map(connectMapper::entityToDTO)
                .collect(Collectors.toList());
    }


    @Override
    public void deleteById(Long id) {
        connectRepository.deleteById(id);
    }

    @Override
    public ConnectDTO save(ConnectDTO connectDTO) {
        Connect connectToSave = connectMapper.dtoToEntity(connectDTO);
        Connect savedConnect = connectRepository.save(connectToSave);
        return connectMapper.entityToDTO(savedConnect);
    }
}
