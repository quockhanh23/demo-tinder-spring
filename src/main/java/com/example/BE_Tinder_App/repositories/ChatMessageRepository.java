package com.example.BE_Tinder_App.repositories;

import com.example.BE_Tinder_App.models.ChatMessage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {

    @Query(value = "select * FROM chat_message WHERE id_conversation = :idConversation and content like CONCAT('%', :searchText, '%')", nativeQuery = true)
    Page<ChatMessage> getAllChatMessagePage(Pageable pageable, String searchText, Long idConversation);

    @Query(value = "select * FROM chat_message WHERE id_conversation = :idConversation", nativeQuery = true)
    Page<ChatMessage> getAllChatMessagePage(Pageable pageable, Long idConversation);
}
