package com.example.BE_Tinder_App.services.impl;

import com.example.BE_Tinder_App.models.Conversation;
import com.example.BE_Tinder_App.repositories.ConversationRepository;
import com.example.BE_Tinder_App.services.ConversationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConversationServiceImpl implements ConversationService {

    private final ConversationRepository conversationRepository;

    @Override
    public void saveConversation(Long senderId, Long recipientId) {
        Conversation conversation1 = new Conversation();
        conversation1.setCreatedAt(new Date());
        conversation1.setSenderId(senderId);
        conversation1.setRecipientId(recipientId);

        Conversation conversation2 = new Conversation();
        conversation2.setCreatedAt(new Date());
        conversation2.setSenderId(recipientId);
        conversation2.setRecipientId(senderId);

        conversationRepository.saveAll(List.of(conversation1, conversation2));
    }

    @Override
    public Conversation getConversation(Long senderId, Long recipientId) {
        Optional<Conversation> conversation = conversationRepository
                .findAllBySenderIdAndRecipientId(senderId, recipientId);
        if (conversation.isEmpty()) {
            Optional<Conversation> conversation1 = conversationRepository
                    .findAllBySenderIdAndRecipientId(recipientId, senderId);
            if (conversation1.isEmpty()) {
                throw new RuntimeException();
            }
            return conversation1.get();
        }
        return conversation.get();

    }
}
