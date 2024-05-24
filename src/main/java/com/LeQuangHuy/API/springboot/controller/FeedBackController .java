package com.LeQuangHuy.API.springboot.controller;

import com.LeQuangHuy.API.springboot.dto.ConnectDTO;
import com.LeQuangHuy.API.springboot.dto.FeedBackDTO;
import com.LeQuangHuy.API.springboot.filter.FeedBackFilter;
import com.LeQuangHuy.API.springboot.model.FeedBack;
import com.LeQuangHuy.API.springboot.service.ConnectService;
import com.LeQuangHuy.API.springboot.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.OrderBy;
import java.util.List;
@RestController
@RequestMapping("/feedBacks")
public class FeedBackController extends BaseController<FeedBackDTO, FeedBackFilter, FeedBack,Long> {
    private final FeedBackService feedBackService;


    @Autowired
    public FeedBackController(FeedBackService feedBackService) {
        super(feedBackService);
        this.feedBackService = feedBackService;
    }

    @GetMapping
    public Page<FeedBackDTO> getFeedBacks(@RequestParam(required = false) Long userId,
                                          @RequestParam(required = false) Integer rate,
                                          @RequestParam(defaultValue = "asc") String orderBy,
                                          @RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        FeedBackFilter filter = new FeedBackFilter();
        if (userId != null || rate != null) {
            if ("desc".equalsIgnoreCase(orderBy)) {
                return feedBackService.findWithFilterAndSortByRateDesc(pageable,userId,rate);
            } else {
                return feedBackService.findWithFilterAndSortByRateAsc(pageable,userId,rate);
            }
        } else {
            List<FeedBackDTO> allFeedBacks = feedBackService.getAll();
            return new PageImpl<>(allFeedBacks, pageable, allFeedBacks.size());
        }
    }
}
