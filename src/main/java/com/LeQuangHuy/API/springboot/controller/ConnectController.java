package com.LeQuangHuy.API.springboot.controller;


import com.LeQuangHuy.API.springboot.dto.ConnectDTO;
import com.LeQuangHuy.API.springboot.service.ConnectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/connects")
public class ConnectController {

    private final ConnectService connectService;

    @Autowired
    public ConnectController(ConnectService connectService) {
        this.connectService = connectService;
    }

    @GetMapping
    public List<ConnectDTO> getConnects(@RequestParam(required = false) Long userId,@RequestParam(required = false) String type) {
        if (userId != null && type != null) {
            return connectService.findByUserIdAndType(userId, type);
        } else if (userId != null) {
            return connectService.findByUserId(userId);
        } else if (type != null) {
            return connectService.findByType(type);
        } else {
            return connectService.getAll();
        }
    }

    @PostMapping("/connects")
    public ResponseEntity<ConnectDTO> createConnect(@RequestBody ConnectDTO connectDTO) {
        ConnectDTO savedConnectDTO = connectService.save(connectDTO);
        return ResponseEntity.ok(savedConnectDTO);
    }


    @DeleteMapping("/{id}")
    public void deleteConnectById(@PathVariable Long id) {
        connectService.deleteById(id);
    }

}
