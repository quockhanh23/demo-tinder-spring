package com.example.BE_Tinder_App.services;

import com.example.BE_Tinder_App.dto.ChangePassword;
import com.example.BE_Tinder_App.dto.UserInfo;
import com.example.BE_Tinder_App.models.User;

public interface UserService {

    void createUser(User user);

    User findById(Long idUser);

    User changePassword(ChangePassword changePassword);

    User updateUser(Long idUser, User user);

    UserInfo login(String username, String password);

    void softDeleteUser(Long idUser);
}
