package com.example.BE_Tinder_App.controllers;

import com.example.BE_Tinder_App.models.Image;
import com.example.BE_Tinder_App.services.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/images")
@RequiredArgsConstructor
public class ImageController {
    private final ImageService imageService;

    @GetMapping("")
    public ResponseEntity<Object> getAllImage(@RequestParam Long idUser) {
        return new ResponseEntity<>(HttpStatus.OK);
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
