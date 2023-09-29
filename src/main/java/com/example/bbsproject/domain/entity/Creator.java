package com.example.bbsproject.domain.entity;

import lombok.Builder;
import lombok.Getter;

// mapper 바인딩이안되면 @Setter 추가 해서 테스트
@Getter
@Builder
public class Creator {

    private Long creatorId; // sequence
    private String channelId;
    private String channelName;
    private int channelSubscriberNumbers;
    private String userId;

}
