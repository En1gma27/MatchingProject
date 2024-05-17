package com.LeQuangHuy.API.springboot.service;
import com.LeQuangHuy.API.springboot.dto.FeedBackDTO;
import com.LeQuangHuy.API.springboot.model.FeedBack;

import java.util.List;
public interface FeedBackService extends BaseService{


    List<FeedBackDTO> findByUserId(Long userId);

    List<FeedBackDTO> findByRate(Integer  rate);

    List<FeedBackDTO> findByUserIdAndRate(Long userId, Integer rate);

    List<FeedBackDTO> findAllByOrderByRateAsc();

    List<FeedBackDTO> findAllByOrderByRateDesc();

    FeedBackDTO save(FeedBackDTO feedBackDTO);
}
