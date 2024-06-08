package com.LeQuangHuy.API.springboot.repository;

import com.LeQuangHuy.API.springboot.dto.FeedBackDTO;
import com.LeQuangHuy.API.springboot.model.FeedBack;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface FeedBackRepository extends BaseRepository<FeedBack, Long> {

    @Query("SELECT f FROM FeedBack f WHERE " +
            "(:rate IS NULL OR f.rate = :rate) " + // Filter by rate
            "AND (:userId IS NULL OR f.user.id = :userId)" + // Filter by userId
            "ORDER BY f.rate DESC") // Default order by rate DESC
    Page<FeedBack> findWithFilterAndSortByRateDesc(Pageable pageable,
                                                   @Param("rate") Integer rate,
                                                   @Param("userId") Long userId);

    @Query("SELECT f FROM FeedBack f WHERE " +
            "(:rate IS NULL OR f.rate = :rate) " + // Filter by rate
            "AND (:userId IS NULL OR f.user.id = :userId)" + // Filter by userId
            "ORDER BY f.rate ASC") // Order by rate ASC
    Page<FeedBack> findWithFilterAndSortByRateAsc(Pageable pageable,
                                                  @Param("rate") Integer rate,
                                                  @Param("userId") Long userId);

}
