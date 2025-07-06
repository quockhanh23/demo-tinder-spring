package com.example.BE_Tinder_App.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    private Long id;
    private String username;
    private Date dateOfBird;
    private String avatar;
    private String coverImage;
    private Date createdAt;
    private Date updatedAt;
    private String status;
}
