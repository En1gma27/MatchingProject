package com.LeQuangHuy.API.springboot.service.Impl;
import com.LeQuangHuy.API.springboot.dto.BaseDTO;
import com.LeQuangHuy.API.springboot.dto.FeedBackDTO;
import com.LeQuangHuy.API.springboot.mapper.FeedBackMapper;
import com.LeQuangHuy.API.springboot.model.FeedBack;
import com.LeQuangHuy.API.springboot.repository.FeedBackRepository;
import com.LeQuangHuy.API.springboot.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class FeedBackServiceImpl implements FeedBackService {
    private final FeedBackRepository feedBackRepository;
    private final FeedBackMapper feedBackMapper;

    @Autowired
    public FeedBackServiceImpl(FeedBackRepository feedBackRepository, FeedBackMapper feedBackMapper) {
        this.feedBackRepository= feedBackRepository;
        this.feedBackMapper = feedBackMapper;
    }

    @Override
    public List<FeedBackDTO> getAll() {
        List<FeedBack> feedBacks = feedBackRepository.findAll();
        return feedBacks.stream().map(feedBackMapper::entityToDTO ).collect(Collectors.toList());
    }

    @Override
    public BaseDTO findById(Long id) {
        return null;
    }

    @Override
    public BaseDTO update(Long id, BaseDTO updatedDTO) {
        return null;
    }

    @Override
    public List<FeedBackDTO> findByUserId(Long userId) {
        List<FeedBack> feedBacks = feedBackRepository.findByUserId(userId);
        return feedBacks.stream().map(feedBackMapper::entityToDTO).collect(Collectors.toList());
    }

    @Override
    public List<FeedBackDTO> findByRate(Integer  rate) {
        return feedBackRepository.findByRate(rate).stream()
                .map(feedBackMapper::entityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<FeedBackDTO> findByUserIdAndRate(Long userId, Integer rate) {
        return feedBackRepository.findByUserIdAndRate(userId,rate).stream()
                .map(feedBackMapper::entityToDTO)
                .collect(Collectors.toList());
    }


    @Override
    public void deleteById(Long id) {
        feedBackRepository.deleteById(id);
    }

    @Override
    public BaseDTO save(BaseDTO dto) {
        return null;
    }

    @Override
    public FeedBackDTO save(FeedBackDTO feedBackDTO) {
        FeedBack feedBackToSave = feedBackMapper.dtoToEntity(feedBackDTO);
        FeedBack savedFeedBack = feedBackRepository.save(feedBackToSave);
        return feedBackMapper.entityToDTO(savedFeedBack);
    }


    @Override
    public List<FeedBackDTO> findAllByOrderByRateAsc() {
        List<FeedBack> feedBacks = feedBackRepository.findAllByOrderByRateAsc();
        return feedBacks.stream().map(feedBackMapper::entityToDTO).collect(Collectors.toList());
    }

    @Override
    public List<FeedBackDTO> findAllByOrderByRateDesc() {
        List<FeedBack> feedBacks = feedBackRepository.findAllByOrderByRateDesc();
        return feedBacks.stream().map(feedBackMapper::entityToDTO).collect(Collectors.toList());
    }
}
