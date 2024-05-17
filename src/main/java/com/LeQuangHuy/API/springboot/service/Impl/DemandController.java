package com.LeQuangHuy.API.springboot.controller;

import com.LeQuangHuy.API.springboot.dto.CharacterDTO;
import com.LeQuangHuy.API.springboot.dto.ConnectDTO;
import com.LeQuangHuy.API.springboot.dto.DemandDTO;
import com.LeQuangHuy.API.springboot.service.ConnectService;
import com.LeQuangHuy.API.springboot.service.DemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/demands")
public class DemandController {
    private final DemandService demandService;

    @Autowired
    public DemandController(DemandService demandService) {
        this.demandService = demandService;
    }

    @GetMapping
    public List<DemandDTO> getDemands(@RequestParam(required = false) Long userId, @RequestParam(required = false) String type) {
        if (userId != null && type != null) {
            return demandService.findByUserIdAndDemandType(userId, type);
        } else if (userId != null) {
            return demandService.findByUserId(userId);
        } else if (type != null) {
            return demandService.findByDemandType(type);
        } else {
            return demandService.getAll();
        }
    }

    @PostMapping("/demands")
    public ResponseEntity<DemandDTO> createDemand(@RequestBody DemandDTO demandDTO) {
        DemandDTO savedDemandDTO = demandService.save(demandDTO);
        return ResponseEntity.ok(savedDemandDTO);
    }


    @PutMapping("/{id}")
    public ResponseEntity<DemandDTO> updateDemand(@PathVariable Long id, @RequestBody DemandDTO updatedDemandDTO) {
        DemandDTO savedDemandDTO = demandService.update(id, updatedDemandDTO);
        if (savedDemandDTO != null) {
            return ResponseEntity.ok(savedDemandDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteConnectById(@PathVariable Long id) {
        demandService.deleteById(id);
    }
}
