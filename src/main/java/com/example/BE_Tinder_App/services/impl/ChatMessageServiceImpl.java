package com.example.BE_Tinder_App.services.impl;

import com.example.BE_Tinder_App.models.ChatMessage;
import com.example.BE_Tinder_App.repositories.ChatMessageRepository;
import com.example.BE_Tinder_App.services.ChatMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatMessageServiceImpl implements ChatMessageService {

    private final ChatMessageRepository chatMessageRepository;

    @Override
    public void saveChatMessage(ChatMessage chatMessage) {
        chatMessageRepository.save(chatMessage);
    }
}
