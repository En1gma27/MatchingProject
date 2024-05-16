package com.LeQuangHuy.API.springboot.controller;

import com.LeQuangHuy.API.springboot.dto.ConnectDTO;
import com.LeQuangHuy.API.springboot.dto.FeedBackDTO;
import com.LeQuangHuy.API.springboot.service.ConnectService;
import com.LeQuangHuy.API.springboot.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/feedBacks")
public class FeedBackController {
    private final FeedBackService feedBackService;

    @Autowired
    public FeedBackController(FeedBackService feedBackService) {
        this.feedBackService = feedBackService;
    }


    @GetMapping
    public List<FeedBackDTO> getFeedBacks(@RequestParam(required = false) Long userId,
                                          @RequestParam(required = false) Integer rate,
                                          @RequestParam(required = false) String orderBy) {
        if ("asc".equalsIgnoreCase(orderBy)) {
            return feedBackService.findAllByOrderByRateAsc();
        } else if ("desc".equalsIgnoreCase(orderBy)) {
            return feedBackService.findAllByOrderByRateDesc();
        } else if (userId != null && rate != null) {
            return feedBackService.findByUserIdAndRate(userId, rate);
        } else if (userId != null) {
            return feedBackService.findByUserId(userId);
        } else if (rate != null) {
            return feedBackService.findByRate(rate);
        } else {
            return feedBackService.getAll();
        }
    }
    @PostMapping("/feedBacks")
    public ResponseEntity<FeedBackDTO> createFeedBack(@RequestBody FeedBackDTO feedBackDTO) {
        FeedBackDTO savedFeedBackDTO = feedBackService.save(feedBackDTO);
        return ResponseEntity.ok(savedFeedBackDTO);
    }


    @DeleteMapping("/{id}")
    public void deleteConnectById(@PathVariable Long id) {
        feedBackService.deleteById(id);
    }
}
