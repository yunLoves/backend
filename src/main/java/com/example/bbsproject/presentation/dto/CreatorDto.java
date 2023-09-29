package com.example.bbsproject.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class CreatorDto { // Outer class

    // Nested Class -> 요청과 응답을 dto outer class 에 응집

    public static class SelectListRequest {

    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class SelectResponse {
        private Long creatorId; // sequence
        private String channelId;
        private String channelName;
        private int channelSubscriberNumbers;
        private String userId;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor  //기본생성자 만들어줌
    public static class InsertRequest {

        private String channelId;
        private String channelName;
        private int channelSubscriberNumbers;
        private String userId;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class InsertResponse {
        private Long creatorId; // sequence
        private String channelId;
        private String channelName;
        private int channelSubscriberNumbers;
        private String userId;
    }


}
