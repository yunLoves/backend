package com.example.bbsproject.domain.service;

import com.example.bbsproject.domain.entity.Creator;
import com.example.bbsproject.infrastructure.repository.CreatorRepository;
import com.example.bbsproject.presentation.dto.CreatorDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreatorService {

    private final CreatorRepository creatorRepository;

    public CreatorDto.SelectResponse selectCreator(Long creatorId) {
        Creator creator = creatorRepository.selectCreator(creatorId);

        // Entity -> Dto
        return CreatorDto.SelectResponse.builder()
                .creatorId(creator.getCreatorId())
                .channelName(creator.getChannelName())
                .channelId(creator.getChannelId())
                .channelSubscriberNumbers(creator.getChannelSubscriberNumbers())
                .userId(creator.getUserId())
                .build();
    }

    public void insertCreator(CreatorDto.InsertRequest request) {
        Creator creator = Creator.builder()
                .channelName(request.getChannelName())
                .channelId(request.getChannelId())
                .channelSubscriberNumbers(request.getChannelSubscriberNumbers())
                .userId(request.getUserId())
                .build();

        creatorRepository.insertCreator(creator);
    }




}

/*
Annotation Processor -> settings 활성화
Lombok Plugin -> 마켓 플레이스에서 설치
 */


