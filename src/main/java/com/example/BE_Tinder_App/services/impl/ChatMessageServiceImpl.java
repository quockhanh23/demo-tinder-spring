package com.example.BE_Tinder_App.services.impl;

import com.example.BE_Tinder_App.models.ChatMessage;
import com.example.BE_Tinder_App.repositories.ChatMessageRepository;
import com.example.BE_Tinder_App.services.ChatMessageService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatMessageServiceImpl implements ChatMessageService {

    private final ChatMessageRepository chatMessageRepository;

    @Override
    public void saveChatMessage(ChatMessage chatMessage) {
        chatMessageRepository.save(chatMessage);
    }

    @Override
    public Page<ChatMessage> getAllChatMessagePage(Pageable pageable, String searchText, Long idConversation) {
        if (StringUtils.isEmpty(searchText)) {
            return chatMessageRepository.getAllChatMessagePage(pageable, idConversation);
        } else {
            return chatMessageRepository.getAllChatMessagePage(pageable, searchText, idConversation);
        }
    }
}
