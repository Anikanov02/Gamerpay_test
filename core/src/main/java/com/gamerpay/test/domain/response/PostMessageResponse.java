package com.gamerpay.test.domain.response;

import com.gamerpay.test.domain.dto.MessageDto;
import com.gamerpay.test.domain.model.Message;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostMessageResponse {
    private final Long id;
    private final String content;
    private String message;

    public static PostMessageResponse convert(Message message) {
        return PostMessageResponse.builder()
                .content(message.getContent())
                .id(message.getId())
                .build();
    }

    public static PostMessageResponse convert(MessageDto message) {
        return PostMessageResponse.builder()
                .content(message.getContent())
                .id(message.getId())
                .build();
    }
}
