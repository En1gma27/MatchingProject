package com.LeQuangHuy.API.springboot.repository;

import com.LeQuangHuy.API.springboot.dto.FeedBackDTO;
import com.LeQuangHuy.API.springboot.model.FeedBack;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface FeedBackRepository extends BaseRepository<FeedBack, Long> {

    List<FeedBack> findByUserId (Long userId);
    List<FeedBack> findByRate(Integer  rate);
    List<FeedBack> findByUserIdAndRate(Long userId, int rate);
    List<FeedBack> findAllByOrderByRateAsc();
    List<FeedBack> findAllByOrderByRateDesc();


}
