package com.LeQuangHuy.API.springboot.mapper;

import java.util.List;
import java.util.Optional;


public interface BaseMapper<E, DTO> {

    DTO entityToDTO(E entity);

    E dtoToEntity(DTO dto);

    default Optional<DTO> entityToOptionalDTO(Optional<E> entityOptional) {
        return entityOptional.map(this::entityToDTO);
    }
}
