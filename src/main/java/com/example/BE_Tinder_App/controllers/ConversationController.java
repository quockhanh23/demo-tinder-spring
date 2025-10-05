package com.example.BE_Tinder_App.controllers;

import com.example.BE_Tinder_App.models.ChatMessage;
import com.example.BE_Tinder_App.services.ConversationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/conversations")
@RequiredArgsConstructor
public class ConversationController {

    private final ConversationService conversationService;
    private final SimpMessagingTemplate messagingTemplate;

    @GetMapping("/getConversation")
    public ResponseEntity<Object> getConversation(
            @RequestParam String senderId, @RequestParam String recipientId) {
        return new ResponseEntity<>(conversationService.getConversation(senderId, recipientId), HttpStatus.OK);
    }

    @PostMapping("/addConversation")
    public ResponseEntity<Object> addConversation(String senderId, String recipientId) {
        return new ResponseEntity<>(conversationService.saveConversation(senderId, recipientId), HttpStatus.OK);
    }

    @MessageMapping("/chat")
    public void processMessage(@Payload ChatMessage chatMessage) {

        // gửi cho người nhận (theo user destination)
        messagingTemplate.convertAndSendToUser(
                String.valueOf(chatMessage.getRecipientId()),
                "/queue/messages",
                chatMessage
        );

        // gửi lại cho chính sender
        messagingTemplate.convertAndSendToUser(
                String.valueOf(chatMessage.getSenderId()),
                "/queue/messages",
                chatMessage
        );

    }
}
