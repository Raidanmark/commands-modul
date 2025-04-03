package org.example.api.controllers;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.exceptions.BadRequestException;
import org.example.model.entities.ChatSessionEntity;
import org.example.services.dto.ChatSessionDto;
import org.example.services.factories.ChatSessionDtoFactory;
import org.example.model.repositories.ChatSessionRepository;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Transactional
@RestController
public class ChatSessionController {
    ChatSessionRepository chatSessionRepository;

    ChatSessionDtoFactory chatSessionDtoFactory;

    public static final String CREATE_CHAT_SESSION = "/api/chat/sessions";
    public static final String GET_CHAT_SESSION = "/api/chat/sessions";

    @PostMapping(CREATE_CHAT_SESSION)
    public ChatSessionDto createChatSession(@RequestParam String chatId, String source, String message) {


        if (chatId == null || chatId.isEmpty()) {
            throw new BadRequestException("Chat id cannot be empty");
        }




        ChatSessionEntity chatSession = chatSessionRepository.saveAndFlush(
                ChatSessionEntity.builder()
                        .chatId(chatId)
                        .source(source)
                        .build()
        );

        return chatSessionDtoFactory.makeChatSessionDto(chatSession);
    }

    @GetMapping(GET_CHAT_SESSION)
    public ChatSessionDto getChatSession(@PathVariable Long id) {
        return chatSessionDtoFactory.makeChatSessionDto(chatSessionRepository.getOne(id));
    }


}
