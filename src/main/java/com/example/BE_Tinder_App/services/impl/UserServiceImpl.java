package com.example.BE_Tinder_App.services.impl;

import com.example.BE_Tinder_App.constant.MessageConstants;
import com.example.BE_Tinder_App.dto.ChangePassword;
import com.example.BE_Tinder_App.exeption.InvalidException;
import com.example.BE_Tinder_App.models.User;
import com.example.BE_Tinder_App.repositories.UserRepository;
import com.example.BE_Tinder_App.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User findById(Long idUser) {
        Optional<User> userOptional = userRepository.findById(idUser);
        if (userOptional.isEmpty()) {
            throw new InvalidException(MessageConstants.NOT_FOUND);
        }
        return userOptional.get();
    }

    @Override
    public void changePassword(ChangePassword changePassword) {
        User user = findById(changePassword.getIdUser());
        user.setPassword(changePassword.getNewPassword());
        user.setConfirmPassword(changePassword.getConfirmPassword());
        userRepository.save(user);
    }

    @Override
    public User updateUser(Long idUser, User user) {
        User userUpdate = findById(idUser);
        userUpdate.setCoverImage(user.getCoverImage());
        userUpdate.setAvatar(user.getAvatar());
        userUpdate.setDateOfBird(user.getDateOfBird());
        userUpdate.setUpdatedAt(new Date());
        userRepository.save(userUpdate);
        return userUpdate;
    }
}
