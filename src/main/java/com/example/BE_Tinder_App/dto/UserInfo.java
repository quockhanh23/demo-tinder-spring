package com.example.BE_Tinder_App.dto;

import com.example.BE_Tinder_App.common.UserStatus;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserInfo {
    private Long id;
    private String username;
    private Date dateOfBird;
    private String avatar;
    private String coverImage;
    private Date createdAt;
    private Date updatedAt;
    private UserStatus status;
    private String gender;
}
