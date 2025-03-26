package org.example.services.factories;

import org.example.services.dto.ChatSessionDto;
import org.example.model.entities.ChatSessionEntity;
import org.springframework.stereotype.Component;

@Component
public class ChatSessionDtoFactory {
    public ChatSessionDto makeChatSessionDto(ChatSessionEntity entity) {
        return ChatSessionDto.builder()
                .id(entity.getId())
                .source(entity.getSource())
                .status(entity.getStatus())
                .chatId(entity.getChatId())
                .build();
    }
}
