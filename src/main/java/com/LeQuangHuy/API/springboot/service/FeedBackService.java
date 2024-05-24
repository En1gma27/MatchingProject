package com.LeQuangHuy.API.springboot.service;
import com.LeQuangHuy.API.springboot.dto.FeedBackDTO;
import com.LeQuangHuy.API.springboot.filter.FeedBackFilter;
import com.LeQuangHuy.API.springboot.model.FeedBack;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
public interface FeedBackService extends BaseService<FeedBackDTO, FeedBackFilter,FeedBack, Long>{

    Page<FeedBackDTO> findWithFilterAndSortByRateDesc(Pageable pageable,
                                                      Long userId,  Integer rate);
    Page<FeedBackDTO> findWithFilterAndSortByRateAsc(Pageable pageable,
                                                     Long userId, Integer rate);
}
