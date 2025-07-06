package com.example.BE_Tinder_App.controllers;

import com.example.BE_Tinder_App.repositories.SettingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/settings")
@RequiredArgsConstructor
public class SettingController {

    private final SettingRepository settingRepository;
}
