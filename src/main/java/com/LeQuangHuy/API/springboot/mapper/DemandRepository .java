package com.LeQuangHuy.API.springboot.repository;

import com.LeQuangHuy.API.springboot.dto.DemandDTO;
import com.LeQuangHuy.API.springboot.model.Demand;

import java.util.List;

public interface DemandRepository extends  BaseRepository<Demand, Long> {
    List<Demand> findByUserId (Long userId);
    List<Demand> findByType(String type );
    List<Demand> findByUserIdAndType(Long userId, String type);
}
