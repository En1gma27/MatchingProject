package com.LeQuangHuy.API.springboot.service.Impl;
import com.LeQuangHuy.API.springboot.dto.FeedBackDTO;
import com.LeQuangHuy.API.springboot.mapper.FeedBackMapper;
import com.LeQuangHuy.API.springboot.model.Connect;
import com.LeQuangHuy.API.springboot.model.Demand;
import com.LeQuangHuy.API.springboot.model.FeedBack;
import com.LeQuangHuy.API.springboot.model.User;
import com.LeQuangHuy.API.springboot.repository.FeedBackRepository;
import com.LeQuangHuy.API.springboot.repository.UserRepository;
import com.LeQuangHuy.API.springboot.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class FeedBackServiceImpl implements FeedBackService {
    private final FeedBackRepository feedBackRepository;
    private final FeedBackMapper feedBackMapper;
    private final UserRepository userRepository;

    @Autowired
    public FeedBackServiceImpl(FeedBackRepository feedBackRepository, FeedBackMapper feedBackMapper, UserRepository userRepository) {
        this.feedBackRepository= feedBackRepository;
        this.feedBackMapper = feedBackMapper;
        this.userRepository = userRepository;
    }

    @Override
    public List<FeedBackDTO> getAll() {
        List<FeedBack> feedBacks = feedBackRepository.findAll();
        return feedBacks.stream().map(feedBackMapper::entityToDTO ).collect(Collectors.toList());
    }

    @Override
    public FeedBackDTO findById(Long id) {
        FeedBack feedBack = feedBackRepository.findById(id).orElse(null);
        return feedBack != null ? feedBackMapper.entityToDTO(feedBack) : null;
    }


    @Override
    public FeedBackDTO update(Long id, FeedBackDTO updatedFeedBackDTO) {
        FeedBack existingFeedBack = feedBackRepository.findById(id).orElse(null);
        if (existingFeedBack != null) {
            if (updatedFeedBackDTO.getUserId() != null) {
                User user = userRepository.findById(updatedFeedBackDTO.getUserId()).orElse(null);
                existingFeedBack.setUser(user);
            } else {
                existingFeedBack.setUser(null);
            }
            FeedBack savedFeedBack = feedBackRepository.save(existingFeedBack);
            return feedBackMapper.entityToDTO(savedFeedBack);
        } else {
            return null;
        }
    }


    @Override
    public void deleteById(Long id) {
        feedBackRepository.deleteById(id);
    }



    @Override
    public FeedBackDTO save(FeedBackDTO feedBackDTO) {
        FeedBack feedBackToSave = feedBackMapper.dtoToEntity(feedBackDTO);
        if (feedBackDTO.getUserId() != null) {
            User user = userRepository.findById(feedBackDTO.getUserId()).orElse(null);
            feedBackToSave.setUser(user);
        }
        FeedBack savedFeedBack = feedBackRepository.save(feedBackToSave);
        return feedBackMapper.entityToDTO(savedFeedBack);
    }


    @Override
    public Page<FeedBackDTO> findWithFilterAndSortByRateDesc(Pageable pageable,
                                                             Long userId,
                                                             Integer rate) {
        Page<FeedBack> pageResult = feedBackRepository.findWithFilterAndSortByRateDesc( pageable,rate,userId);
        return pageResult.map(feedBackMapper::entityToDTO);
    }

    @Override
    public Page<FeedBackDTO> findWithFilterAndSortByRateAsc(Pageable pageable,
                                                            Long userId,
                                                            Integer rate) {
        Page<FeedBack> pageResult = feedBackRepository.findWithFilterAndSortByRateAsc(pageable,rate,userId);
        return pageResult.map(feedBackMapper::entityToDTO);
    }
}
