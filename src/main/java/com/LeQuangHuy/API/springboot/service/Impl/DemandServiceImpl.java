package com.LeQuangHuy.API.springboot.service.Impl;

import com.LeQuangHuy.API.springboot.dto.DemandDTO;
import com.LeQuangHuy.API.springboot.mapper.ConnectMapper;
import com.LeQuangHuy.API.springboot.mapper.DemandMapper;
import com.LeQuangHuy.API.springboot.model.Character;
import com.LeQuangHuy.API.springboot.model.Connect;
import com.LeQuangHuy.API.springboot.model.Demand;
import com.LeQuangHuy.API.springboot.repository.ConnectRepository;
import com.LeQuangHuy.API.springboot.repository.DemandRepository;
import com.LeQuangHuy.API.springboot.service.DemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class DemandServiceImpl implements DemandService {

    private final DemandRepository demandRepository;
    private final DemandMapper demandMapper;

    @Autowired
    public DemandServiceImpl(DemandRepository demandRepository, DemandMapper demandMapper) {
        this.demandRepository= demandRepository;
        this.demandMapper = demandMapper;
    }
    @Override
    public List<DemandDTO> findByUserId(Long userId) {
        List<Demand> demands = demandRepository.findByUserId(userId);
        return demands.stream().map(demandMapper::entityToDTO).collect(Collectors.toList());
    }

    @Override
    public List<DemandDTO> findByDemandType(String type) {
        return demandRepository.findByType(type).stream()
                .map(demandMapper::entityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<DemandDTO> findByUserIdAndDemandType(Long userId, String type) {
        return demandRepository.findByUserIdAndType(userId,type).stream()
                .map(demandMapper::entityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<DemandDTO> getAll() {
        List<Demand> demands = demandRepository.findAll();
        return demands.stream().map(demandMapper::entityToDTO ).collect(Collectors.toList());
    }

    @Override
    public DemandDTO findById(Long id) {
        return null;
    }

    @Override
    public DemandDTO update(Long id, DemandDTO  updatedDemandDTO) {
        Demand existingDemand = demandRepository.findById(id).orElse(null);
        if (existingDemand != null) {
            existingDemand.setType(updatedDemandDTO.getType());
            existingDemand.setDescription(updatedDemandDTO.getDescription());
            Demand savedDemand = demandRepository.save(existingDemand);
            return demandMapper.entityToDTO(savedDemand);
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
        Demand savedDemand = demandRepository.save(demandToSave);
        return demandMapper.entityToDTO(savedDemand);
    }
}
