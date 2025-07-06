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

    @GetMapping("/getDetailUser")
    public ResponseEntity<Object> getDetailUser(@RequestParam Long idUser) {
        User user = userService.findById(idUser);
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(user, userInfo);
        return new ResponseEntity<>(userInfo, HttpStatus.OK);
    }

    @PostMapping("/addNewUser")
    public ResponseEntity<Object> addNewUser(@RequestBody User user) {
        userService.createUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/changePassword")
    public ResponseEntity<Object> changePassword(@RequestBody ChangePassword changePassword) {
        return new ResponseEntity<>(userService.changePassword(changePassword), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody User user) {
        return new ResponseEntity<>(userService.login(user.getUsername(), user.getPassword()), HttpStatus.OK);
    }

    @PutMapping("/updateUser")
    public ResponseEntity<Object> updateUser(@RequestParam Long idUser, User user) {
        User userUpdate = userService.updateUser(idUser, user);
        return new ResponseEntity<>(userUpdate, HttpStatus.OK);
    }

    @DeleteMapping("/softDeleteUser")
    public ResponseEntity<Object> softDeleteUser(@RequestParam Long idUser) {
        userService.softDeleteUser(idUser);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
