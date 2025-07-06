package com.example.BE_Tinder_App.services;

import com.example.BE_Tinder_App.models.Matches;

public interface MatchesService {

    Matches createMatches(Matches matches);

    Matches findById(Long idMatches);
}
