package com.LeQuangHuy.API.springboot.service.Impl;

import com.LeQuangHuy.API.springboot.dto.ConnectDTO;
import com.LeQuangHuy.API.springboot.dto.DemandDTO;
import com.LeQuangHuy.API.springboot.mapper.ConnectMapper;
import com.LeQuangHuy.API.springboot.mapper.DemandMapper;
import com.LeQuangHuy.API.springboot.model.Character;
import com.LeQuangHuy.API.springboot.model.Connect;
import com.LeQuangHuy.API.springboot.model.Demand;
import com.LeQuangHuy.API.springboot.model.User;
import com.LeQuangHuy.API.springboot.repository.ConnectRepository;
import com.LeQuangHuy.API.springboot.repository.DemandRepository;
import com.LeQuangHuy.API.springboot.repository.UserRepository;
import com.LeQuangHuy.API.springboot.service.DemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class DemandServiceImpl implements DemandService {

    private final DemandRepository demandRepository;
    private final DemandMapper demandMapper;
    private final UserRepository userRepository;

    @Autowired
    public DemandServiceImpl(DemandRepository demandRepository, DemandMapper demandMapper, UserRepository userRepository) {
        this.demandRepository = demandRepository;
        this.demandMapper = demandMapper;
        this.userRepository = userRepository;
    }

    @Override
    public List<DemandDTO> getAll() {
        List<Demand> demands = demandRepository.findAll();
        return demands.stream().map(demandMapper::entityToDTO).collect(Collectors.toList());
    }

    @Override
    public DemandDTO findById(Long id) {
        Demand demand = demandRepository.findById(id).orElse(null);
        return demand != null ? demandMapper.entityToDTO(demand) : null;
    }

    @Override
    public DemandDTO update(Long id, DemandDTO updatedDemandDTO) {
        Demand existingDemand = demandRepository.findById(id).orElse(null);
        if (existingDemand != null) {
            existingDemand.setType(updatedDemandDTO.getType());
            existingDemand.setDescription(updatedDemandDTO.getDescription());
            Demand savedDemand = demandRepository.save(existingDemand);
            if (updatedDemandDTO.getUserId() != null) {
                User user = userRepository.findById(updatedDemandDTO.getUserId()).orElse(null);
                existingDemand.setUser(user);
            } else {
                existingDemand.setUser(null);
            }
            Demand savedConnect = demandRepository.save(existingDemand);
            return demandMapper.entityToDTO(savedConnect);
        } else {
            return null;
        }
    }
    @Override
    public void deleteById(Long id) {
        demandRepository.deleteById(id);
    }

    @Override
    public DemandDTO save(DemandDTO demandDTO) {
        Demand demandToSave = demandMapper.dtoToEntity(demandDTO);
        if (demandDTO.getUserId() != null) {
            User user = userRepository.findById(demandDTO.getUserId()).orElse(null);
            demandToSave.setUser(user);
        }
        Demand savedDemand = demandRepository.save(demandToSave);
        return demandMapper.entityToDTO(savedDemand);
    }
    @Override
    public Page<DemandDTO> findWithFilter(Pageable pageable, Long userId, String type, String description) {
        Page<Demand> pageResult = demandRepository.findWithFilter(pageable,userId,type,description);
        return pageResult.map(demandMapper::entityToDTO);
    }
}
