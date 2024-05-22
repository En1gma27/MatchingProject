package com.LeQuangHuy.API.springboot.controller;

import com.LeQuangHuy.API.springboot.dto.ConnectDTO;
import com.LeQuangHuy.API.springboot.service.ConnectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/connects")
public class ConnectController {

    private final ConnectService connectService;

    @Autowired
    public ConnectController(ConnectService connectService) {
        this.connectService = connectService;
    }

     @GetMapping
    public Page<ConnectDTO> getConnects(
            @RequestParam(required = false) Long userId,
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String status,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String groupName,
            Pageable pageable) {
        if (userId != null || id != null || status != null || type != null || groupName != null) {
            return connectService.findWithFilter(pageable, userId, id, status, type, groupName);
        } else {
            List<ConnectDTO> allConnects = connectService.getAll();
            return new PageImpl<>(allConnects, pageable, allConnects.size());
        }
    }

    @PostMapping
    public ResponseEntity<ConnectDTO> createConnect(@RequestBody ConnectDTO connectDTO) {
        ConnectDTO savedConnectDTO = connectService.save(connectDTO);
        return ResponseEntity.ok(savedConnectDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteConnectById(@PathVariable Long id) {
        connectService.deleteById(id);
    }
}
