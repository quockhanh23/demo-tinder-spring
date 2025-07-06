package com.example.BE_Tinder_App.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChangePassword {
    private Long idUser;
    private String oldPassword;
    private String newPassword;
    private String confirmPassword;
}
