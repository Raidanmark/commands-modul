package org.example.controllers;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.dto.ChatSessionDto;
import org.example.factories.ChatSessionDtoFactory;
import org.example.repositories.ChatSessionRepository;
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
    public ChatSessionDto createChatSession(@RequestParam String chatId, String source) {


        return chatSessionDtoFactory.makeChatSessionDto(null);
    }

    @GetMapping(GET_CHAT_SESSION)
    public ChatSessionDto getChatSession(@PathVariable Long id) {
        return chatSessionDtoFactory.makeChatSessionDto(chatSessionRepository.getOne(id));
    }


}
