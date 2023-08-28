package com.gamerpay.test.service;

import com.gamerpay.test.domain.dto.MessageDto;
import com.gamerpay.test.domain.model.Message;
import com.gamerpay.test.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;

    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }

    public Message saveMessage(MessageDto dto) {
        final Message message = Message.builder()
                .content(dto.getContent())
                .build();
        return messageRepository.save(message);
    }
}
