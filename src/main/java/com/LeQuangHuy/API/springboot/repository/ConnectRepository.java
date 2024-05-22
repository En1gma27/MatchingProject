package com.LeQuangHuy.API.springboot.repository;

import com.LeQuangHuy.API.springboot.filter.ConnectFilter;
import com.LeQuangHuy.API.springboot.model.Connect;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ConnectRepository extends BaseRepository<Connect, Long> {

    @Query("SELECT c FROM Connect c WHERE " +
            "(:userId IS NULL OR c.user.id = :userId) " +
            "AND (:id IS NULL OR c.id = :id) " +
            "AND (:type IS NULL OR c.type = :type) " +
            "AND (:status IS NULL OR c.status = :status) " +
            "AND (:groupName IS NULL OR c.groupName = :groupName)")
    Page<Connect> findWithFilter(Pageable pageable, ConnectFilter filter);
                              
}
