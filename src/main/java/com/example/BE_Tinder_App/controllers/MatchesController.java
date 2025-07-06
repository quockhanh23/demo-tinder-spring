package com.example.BE_Tinder_App.controllers;

import com.example.BE_Tinder_App.models.Matches;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/matches")
public class MatchesController {

    @GetMapping("/get-one")
    public ResponseEntity<?> getOneMatches(Long idMatches) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/add-new-matches")
    public ResponseEntity<?> addNewMatches(Matches matches) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update-matches")
    public ResponseEntity<?> updateMatches(Long idMatches) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteMatches(Long idMatches) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
