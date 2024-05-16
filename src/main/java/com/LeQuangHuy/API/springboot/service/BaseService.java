package com.LeQuangHuy.API.springboot.service;

import com.LeQuangHuy.API.springboot.dto.BaseDTO;

import java.util.List;

public interface BaseService<DTO extends BaseDTO> {

    List<DTO> getAll();

    DTO findById(Long id);

    DTO update(Long id, DTO updatedDTO);

    void deleteById(Long id);

    DTO save(DTO dto);
}
