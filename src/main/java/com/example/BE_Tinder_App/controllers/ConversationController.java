package com.example.BE_Tinder_App.controllers;

import com.example.BE_Tinder_App.services.ConversationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/conversations")
@RequiredArgsConstructor
public class ConversationController {

    private final ConversationService conversationService;

    @GetMapping("/getConversation")
    public ResponseEntity<Object> getConversation(
            @RequestParam Long senderId, @RequestParam Long recipientId) {
        return new ResponseEntity<>(conversationService.getConversation(senderId, recipientId), HttpStatus.OK);
    }

    @PostMapping("/addConversation")
    public ResponseEntity<Object> addConversation(Long senderId, Long recipientId) {
        conversationService.saveConversation(senderId, recipientId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
