package com.example.BE_Tinder_App.controllers;

import com.example.BE_Tinder_App.models.Setting;
import com.example.BE_Tinder_App.repositories.SettingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/settings")
@RequiredArgsConstructor
public class SettingController {

    private final SettingRepository settingRepository;

    @GetMapping("/getSetting")
    public ResponseEntity<Object> getSetting(@RequestParam Long idUser) {
        Setting setting = settingRepository.findByIdUser(idUser);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/addNewSetting")
    public ResponseEntity<Object> addNewSetting(@RequestBody Setting setting) {
        return new ResponseEntity<>(settingRepository.save(setting), HttpStatus.OK);
    }

    @PutMapping("/updateSetting")
    public ResponseEntity<Object> updateSetting(@RequestBody Setting request) {
        return new ResponseEntity<>(settingRepository.save(request), HttpStatus.OK);
    }

}
