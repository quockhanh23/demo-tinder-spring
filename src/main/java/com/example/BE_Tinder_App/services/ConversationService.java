package com.example.BE_Tinder_App.services;

import com.example.BE_Tinder_App.models.Conversation;

public interface ConversationService {

    Conversation saveConversation(String senderId, String recipientId);

    Conversation getConversation(String senderId, String recipientId);

    Conversation getConversationById(Long id);
}
