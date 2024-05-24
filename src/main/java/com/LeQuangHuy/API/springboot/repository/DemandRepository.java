package com.LeQuangHuy.API.springboot.repository;

import com.LeQuangHuy.API.springboot.model.Connect;
import com.LeQuangHuy.API.springboot.model.Demand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface  DemandRepository extends BaseRepository<Demand,Long> {

    @Query("SELECT d FROM Demand d WHERE " +
                  "(:userId IS NULL OR d.user.id = :userId) " +
                  "AND (:type IS NULL OR d.type = :type) " +
                  "AND (:description IS NULL OR d.description = :description)")
    Page<Demand> findWithFilter(Pageable pageable,
                                 @Param("userId") Long userId,
                                 @Param("type") String type,
                                 @Param("description") String groupName);

}
