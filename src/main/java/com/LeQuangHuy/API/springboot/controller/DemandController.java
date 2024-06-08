package com.LeQuangHuy.API.springboot.controller;

import com.LeQuangHuy.API.springboot.dto.ConnectDTO;
import com.LeQuangHuy.API.springboot.dto.DemandDTO;
import com.LeQuangHuy.API.springboot.filter.ConnectFilter;
import com.LeQuangHuy.API.springboot.filter.DemandFilter;
import com.LeQuangHuy.API.springboot.model.Connect;
import com.LeQuangHuy.API.springboot.model.Demand;
import com.LeQuangHuy.API.springboot.service.BaseService;
import com.LeQuangHuy.API.springboot.service.ConnectService;
import com.LeQuangHuy.API.springboot.service.DemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@RequestMapping("/demands")
public class DemandController extends BaseController<DemandDTO, DemandFilter, Demand,Long> {
    private final DemandService demandService;

    @Autowired
    public DemandController(DemandService demandService) {
        super(demandService);
        this.demandService = demandService;
    }

    @GetMapping
    public Page<DemandDTO> getDemands(
            @RequestParam(required = false) Long userId,
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String description,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page, size);
        if (userId != null || id != null || type != null || description != null) {
            return demandService.findWithFilter(pageable, userId, type, description);
        } else {
            List<DemandDTO> allDemands = demandService.getAll();
            return new PageImpl<>(allDemands, pageable, allDemands.size());
        }
    }
}
