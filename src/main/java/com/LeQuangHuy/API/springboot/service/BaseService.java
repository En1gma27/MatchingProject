package com.LeQuangHuy.API.springboot.service;
import com.LeQuangHuy.API.springboot.dto.BaseDTO;
import com.LeQuangHuy.API.springboot.filter.BaseFilter;
import com.LeQuangHuy.API.springboot.model.BaseModel;

import java.util.List;

public interface BaseService<DTO extends BaseDTO, FT extends BaseFilter, C extends BaseModel, L extends Long> {


    List<DTO> getAll();

    DTO findById(Long id);

    DTO update(Long id, DTO updatedDTO);

    void deleteById(Long id);

    DTO save(DTO dto);
}
