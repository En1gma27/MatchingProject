package com.LeQuangHuy.API.springboot.controller;

import com.LeQuangHuy.API.springboot.dto.BaseDTO;
import com.LeQuangHuy.API.springboot.filter.BaseFilter;
import com.LeQuangHuy.API.springboot.model.BaseModel;
import com.LeQuangHuy.API.springboot.service.BaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class BaseController<DTO extends BaseDTO, FT extends BaseFilter, C extends BaseModel, L extends Long> {

    private final BaseService<DTO, FT, C, L> service;

    public BaseController(BaseService<DTO, FT, C, L> service) {
        this.service = service;
    }



   @GetMapping("/{id}")
        public ResponseEntity<DTO> getEntityById(@PathVariable("id") Long id) {
           DTO entity = service.findById(id);
              if (entity != null) {
                   return ResponseEntity.ok(entity);
                } else {
                return ResponseEntity.notFound().build();
            }
    }

    @PostMapping
    public ResponseEntity<DTO> createEntity(@RequestBody DTO dto) {
        DTO createdEntity = service.save(dto);
        return ResponseEntity.ok(createdEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DTO> updateEntity(@PathVariable("id") Long id, @RequestBody DTO updatedDTO) {
        DTO updatedEntity = service.update(id, updatedDTO);
        if (updatedEntity != null) {
            return ResponseEntity.ok(updatedEntity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEntityById(@PathVariable("id") Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
