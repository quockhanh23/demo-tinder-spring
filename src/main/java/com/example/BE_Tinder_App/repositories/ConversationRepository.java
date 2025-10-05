package com.example.BE_Tinder_App.repositories;

import com.example.BE_Tinder_App.models.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConversationRepository extends JpaRepository<Conversation, Long> {

    Optional<Conversation> findAllBySenderIdAndRecipientId(String senderId, String recipientId);
}
