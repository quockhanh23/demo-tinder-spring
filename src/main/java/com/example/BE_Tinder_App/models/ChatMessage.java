package com.example.BE_Tinder_App.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createdAt = new Date();
    private Date updatedAt;
    @Column(length = 20)
    private String status;
    @Column(length = 500)
    private String content;
    @NotNull
    private Long idConversation;
    private String senderId;
    private String recipientId;
}
