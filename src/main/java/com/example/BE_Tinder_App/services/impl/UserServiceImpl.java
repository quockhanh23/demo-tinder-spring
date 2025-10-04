package com.example.BE_Tinder_App.services.impl;

import com.example.BE_Tinder_App.common.UserStatus;
import com.example.BE_Tinder_App.constant.MessageConstants;
import com.example.BE_Tinder_App.dto.ChangePassword;
import com.example.BE_Tinder_App.dto.UserInfo;
import com.example.BE_Tinder_App.exeption.InvalidException;
import com.example.BE_Tinder_App.models.HistoryLogin;
import com.example.BE_Tinder_App.models.User;
import com.example.BE_Tinder_App.repositories.HistoryLoginRepository;
import com.example.BE_Tinder_App.repositories.UserRepository;
import com.example.BE_Tinder_App.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final HistoryLoginRepository historyLoginRepository;

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
    public User changePassword(ChangePassword changePassword) {
        User user = findById(changePassword.getIdUser());
        user.setPassword(changePassword.getNewPassword());
        user.setConfirmPassword(changePassword.getConfirmPassword());
        return userRepository.save(user);
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

    @Override
    public UserInfo login(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, password);
        if (Objects.isNull(user)) {
            throw new InvalidException(MessageConstants.NOT_FOUND);
        }
        HistoryLogin historyLogin = new HistoryLogin();
        historyLogin.setIdUserLogin(user.getId());
        historyLoginRepository.save(historyLogin);

        UserInfo userInfo = UserInfo.builder().build();
        BeanUtils.copyProperties(user, userInfo);
        return userInfo;
    }

    @Override
    public void actionsUser(Long idUser, UserStatus action) {
        User user = findById(idUser);
        user.setStatus(action);
        user.setUpdatedAt(new Date());
        userRepository.save(user);
    }

    @Override
    public Page<UserInfo> getAllUserPage(Pageable pageable, String searchText) {
        return userRepository.getAllUserPage(pageable, searchText);
    }

    @Override
    public Page<UserInfo> getAllUserByCondition(Pageable pageable, Long idUser) {
//        Setting setting = settingRepository.findByIdUser(idUser);
//        if (Objects.isNull(setting)) return null;
        return userRepository.getAllUserByCondition(pageable, idUser);
    }

    @Override
    public Page<UserInfo> getAllMatchPage(Pageable pageable, Long idUser) {
        return userRepository.getAllMatchPage(pageable, idUser);
    }

    @Override
    public void checkAdmin(Long idUser) {
        User user = findById(idUser);
        user.getRoles().stream()
                .filter(role -> role.getName().equals("ADMIN"))
                .findFirst().orElseThrow(() -> new InvalidException("Bạn không phải Admin"));
    }
}
