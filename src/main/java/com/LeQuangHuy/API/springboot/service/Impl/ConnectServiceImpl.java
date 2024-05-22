package com.LeQuangHuy.API.springboot.service.Impl;

import com.LeQuangHuy.API.springboot.dto.ConnectDTO;
import com.LeQuangHuy.API.springboot.filter.ConnectFilter;
import com.LeQuangHuy.API.springboot.mapper.ConnectMapper;
import com.LeQuangHuy.API.springboot.model.Connect;
import com.LeQuangHuy.API.springboot.repository.ConnectRepository;
import com.LeQuangHuy.API.springboot.service.ConnectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConnectServiceImpl implements ConnectService {

    private final ConnectRepository connectRepository;
    private final ConnectMapper connectMapper;

    @Autowired
    public ConnectServiceImpl(ConnectRepository connectRepository, ConnectMapper connectMapper) {
        this.connectRepository = connectRepository;
        this.connectMapper = connectMapper;
    }

    @Override
    public List<ConnectDTO> getAll() {
        List<Connect> connects = connectRepository.findAll();
        return connects.stream().map(connectMapper::entityToDTO).collect(Collectors.toList());
    }

    @Override
    public ConnectDTO findById(Long id) {
        Connect connect = connectRepository.findById(id).orElse(null);
        return connect != null ? connectMapper.entityToDTO(connect) : null;
    }

    @Override
    public ConnectDTO update(Long id, ConnectDTO updatedDTO) {
        // Implement update logic here
        return null;
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

    @Override
    public Page<ConnectDTO> findWithFilter(Pageable pageable,
                                           Long userId,
                                           Long id,
                                           Boolean status,
                                           String type,
                                           String groupName) {
        Page<Connect> pageResult = connectRepository.findWithFilter(Pageable pageable, ConnectFilter filter);
        return pageResult.map(connectMapper::entityToDTO);
    }
}
