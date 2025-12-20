package com.example.BE_Tinder_App.services.impl;

import com.example.BE_Tinder_App.models.ChatMessage;
import com.example.BE_Tinder_App.repositories.ChatMessageRepository;
import com.example.BE_Tinder_App.services.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final ChatMessageRepository chatMessageRepository;

    @Override
    public void saveMessage(ChatMessage chatMessage) {
        chatMessageRepository.save(chatMessage);

    }

    @Override
    public Page<ChatMessage> getAllMessageByConversationId(Long idConversation, Pageable pageable) {
        return null;
    }
}
