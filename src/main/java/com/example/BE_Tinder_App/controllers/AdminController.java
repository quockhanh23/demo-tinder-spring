package com.example.BE_Tinder_App.controllers;

import com.example.BE_Tinder_App.common.UserStatus;
import com.example.BE_Tinder_App.dto.UserInfo;
import com.example.BE_Tinder_App.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/admins")
@RequiredArgsConstructor
public class AdminController {

    private final UserService userService;

    @GetMapping("/getAllUser")
    public ResponseEntity<Object> getAllUserPage(
            @RequestParam Long idAdmin,
            @RequestParam String searchText,
            @RequestParam(defaultValue = "0", required = false) int page,
            @RequestParam(defaultValue = "10", required = false) int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<UserInfo> userInfoPage = userService.getAllUserPage(pageable, searchText);
        return new ResponseEntity<>(userInfoPage, HttpStatus.OK);
    }

    @PutMapping("/action")
    public ResponseEntity<Object> actionsUser(@RequestParam Long idUser, @RequestParam UserStatus action) {
        userService.actionsUser(idUser, action);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
