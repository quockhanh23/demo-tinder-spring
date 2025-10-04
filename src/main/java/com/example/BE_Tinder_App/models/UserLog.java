package com.example.BE_Tinder_App.models;

import com.example.BE_Tinder_App.common.UserStatus;
import jakarta.persistence.*;
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
public class UserLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 60)
    private String username;
    @Column(length = 60)
    private String password;
    @Column(length = 60)
    private String confirmPassword;
    @Column(length = 200)
    private String fullName;
    private Date dateOfBird;
    @Lob
    private String avatar;
    @Lob
    private String coverImage;
    private Date createdAt;
    private Date updatedAt;
    private UserStatus status;
    @Column(length = 10)
    private String gender;
}
