package com.example.BE_Tinder_App.services;

import com.example.BE_Tinder_App.models.ChatMessage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MessageService {

    void saveMessage(ChatMessage chatMessage);

    Page<ChatMessage> getAllMessageByConversationId(Long idConversation, Pageable pageable);
}
