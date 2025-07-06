package com.example.BE_Tinder_App.controllers;

import com.example.BE_Tinder_App.models.Image;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/images")
public class ImageController {

    @PostMapping("/add-new-image")
    public ResponseEntity<Object> addNewImage(Image image) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteImage(Long idImage) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
