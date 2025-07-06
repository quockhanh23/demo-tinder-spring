package com.example.BE_Tinder_App.controllers;

import com.example.BE_Tinder_App.models.Matches;
import com.example.BE_Tinder_App.services.MatchesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/matches")
@RequiredArgsConstructor
public class MatchesController {

    private final MatchesService matchesService;

    @PostMapping("/addNewMatches")
    public ResponseEntity<Object> addNewMatches(Matches matches) {
        return new ResponseEntity<>(matchesService.createMatches(matches), HttpStatus.OK);
    }

}
