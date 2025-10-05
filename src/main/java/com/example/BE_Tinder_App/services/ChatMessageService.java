package com.example.BE_Tinder_App.services;

import com.example.BE_Tinder_App.models.ChatMessage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ChatMessageService {

    void saveChatMessage(ChatMessage chatMessage);

    Page<ChatMessage> getAllChatMessagePage(Pageable pageable, String searchText, Long idConversation);
}
