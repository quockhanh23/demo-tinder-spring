package com.example.BE_Tinder_App.services;

import com.example.BE_Tinder_App.models.Conversation;

public interface ConversationService {

    void saveConversation(Long senderId, Long recipientId);

    Conversation getConversation(Long senderId, Long recipientId);
}
