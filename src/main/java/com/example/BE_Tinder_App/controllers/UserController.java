package com.example.BE_Tinder_App.controllers;

import com.example.BE_Tinder_App.dto.ChangePassword;
import com.example.BE_Tinder_App.dto.UserInfo;
import com.example.BE_Tinder_App.models.User;
import com.example.BE_Tinder_App.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/get-one")
    public ResponseEntity<?> getOneUser(Long idUser) {
        User user = userService.findById(idUser);
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(user, userInfo);
        return new ResponseEntity<>(userInfo, HttpStatus.OK);
    }

    @PostMapping("/add-new-user")
    public ResponseEntity<?> addNewUser(User user) {
        userService.createUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/change-password")
    public ResponseEntity<?> changePassword(ChangePassword changePassword) {
        userService.changePassword(changePassword);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(User user) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update-user")
    public ResponseEntity<?> updateUser(Long idUser, User user) {
        User userUpdate = userService.updateUser(idUser, user);
        return new ResponseEntity<>(userUpdate, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteUser(Long idUser) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
