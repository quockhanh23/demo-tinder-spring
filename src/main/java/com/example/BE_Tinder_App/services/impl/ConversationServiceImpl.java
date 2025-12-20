package com.example.BE_Tinder_App.services.impl;

import com.example.BE_Tinder_App.constant.MessageConstants;
import com.example.BE_Tinder_App.exception.InvalidException;
import com.example.BE_Tinder_App.models.Conversation;
import com.example.BE_Tinder_App.repositories.ConversationRepository;
import com.example.BE_Tinder_App.services.ConversationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConversationServiceImpl implements ConversationService {

    private final ConversationRepository conversationRepository;

    @Override
    public Conversation saveConversation(String senderId, String recipientId) {
        Conversation conversation = new Conversation();
        conversation.setCreatedAt(new Date());
        conversation.setSenderId(senderId);
        conversation.setRecipientId(recipientId);
        return conversationRepository.save(conversation);
    }

    @Override
    public Conversation getConversation(String senderId, String recipientId) {
        Optional<Conversation> conversation = conversationRepository
                .findAllBySenderIdAndRecipientId(senderId, recipientId);
        if (conversation.isEmpty()) {
            Optional<Conversation> conversation1 = conversationRepository
                    .findAllBySenderIdAndRecipientId(recipientId, senderId);
            if (conversation1.isEmpty()) {
                throw new InvalidException(MessageConstants.NOT_FOUND);
            }
            return conversation1.get();
        }
        return conversation.get();
    }

    @Override
    public Conversation getConversationById(Long id) {
        Optional<Conversation> conversation = conversationRepository.findById(id);
        if (conversation.isEmpty()) {
            throw new InvalidException(MessageConstants.NOT_FOUND);
        }
        return conversation.get();
    }
}
