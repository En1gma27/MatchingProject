package com.LeQuangHuy.API.springboot.service;

import com.LeQuangHuy.API.springboot.dto.ConnectDTO;
import com.LeQuangHuy.API.springboot.filter.ConnectFilter;
import com.LeQuangHuy.API.springboot.model.Connect;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ConnectService extends BaseService<ConnectDTO, ConnectFilter, Connect, Long> {

    Page<ConnectDTO> findWithFilter(Pageable pageable,
                                    Long userId,
                                    Long id,
                                    Boolean status,
                                    String type,
                                    String groupName);
}
