package com.example.BE_Tinder_App.controllers;

import com.example.BE_Tinder_App.dto.UserInfo;
import com.example.BE_Tinder_App.models.Image;
import com.example.BE_Tinder_App.services.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/images")
@RequiredArgsConstructor
public class ImageController {
    private final ImageService imageService;

    @GetMapping("/getAllImage")
    public ResponseEntity<Object> getAllImagePage(
            @RequestParam Long idUser,
            @RequestParam(defaultValue = "0", required = false) int page,
            @RequestParam(defaultValue = "15", required = false) int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<UserInfo> userInfoPage = imageService.getAllImagePage(pageable, idUser);
        return new ResponseEntity<>(userInfoPage, HttpStatus.OK);
    }

    @PostMapping("/addNewImage")
    public ResponseEntity<Object> addNewImage(@RequestBody Image image) {
        imageService.createImage(image);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/sortDeleteImage")
    public ResponseEntity<Object> sortDeleteImage(@RequestParam Long idImage) {
        imageService.updateStatusImage("", idImage);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
