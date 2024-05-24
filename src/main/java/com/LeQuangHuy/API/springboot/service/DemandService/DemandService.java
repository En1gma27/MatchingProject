package com.LeQuangHuy.API.springboot.service;

import com.LeQuangHuy.API.springboot.dto.DemandDTO;
import com.LeQuangHuy.API.springboot.filter.DemandFilter;
import com.LeQuangHuy.API.springboot.model.Demand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DemandService  extends BaseService<DemandDTO, DemandFilter, Demand, Long>{
    Page<DemandDTO> findWithFilter(Pageable pageable,
                                   Long userId, String type, String description);

}
