package com.example.BE_Tinder_App.controllers;

import com.example.BE_Tinder_App.models.Block;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/blocks")
public class BlockController {

    @GetMapping("/get-one")
    public ResponseEntity<?> getOneBlock(Long idBlock) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/add-new-block")
    public ResponseEntity<?> addNewBlock(Block block) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update-block")
    public ResponseEntity<?> updateBlock(Long idBlock) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteBlock(Long idBlock) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
