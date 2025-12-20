package com.example.BE_Tinder_App.services;

import com.example.BE_Tinder_App.common.UserStatus;
import com.example.BE_Tinder_App.dto.ChangePassword;
import com.example.BE_Tinder_App.dto.UserInfo;
import com.example.BE_Tinder_App.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    void createUser(User user);

    User findById(Long idUser);

    User changePassword(ChangePassword changePassword);

    User updateUser(Long idUser, User user);

    UserInfo login(String username, String password);

    void actionsUser(Long idUser, UserStatus action);

    Page<UserInfo> getAllUserPage(Pageable pageable, String searchText);

    Page<UserInfo> getAllUserByCondition(Pageable pageable, Long idUser);

    Page<UserInfo> getAllMatchPage(Pageable pageable, Long idUser);

    void checkAdmin(Long idUser);
}
