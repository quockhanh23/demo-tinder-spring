package com.example.BE_Tinder_App.controllers;

import com.example.BE_Tinder_App.models.Image;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/images")
public class ImageController {

    @GetMapping("/get-one")
    public ResponseEntity<?> getOneImage(Long idImage) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/add-new-image")
    public ResponseEntity<?> addNewImage(Image image) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteImage(Long idImage) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
