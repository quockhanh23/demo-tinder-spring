package com.example.BE_Tinder_App.models;

import com.example.BE_Tinder_App.common.UserStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String confirmPassword;
    private Date dateOfBird;
    private String avatar;
    private String coverImage;
    private Date createdAt;
    private Date updatedAt;
    private UserStatus status;
    private String gender;
}
