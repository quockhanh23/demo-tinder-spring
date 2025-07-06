package com.example.BE_Tinder_App.services.impl;

import com.example.BE_Tinder_App.constant.MessageConstants;
import com.example.BE_Tinder_App.exeption.InvalidException;
import com.example.BE_Tinder_App.models.Matches;
import com.example.BE_Tinder_App.repositories.MatchesRepository;
import com.example.BE_Tinder_App.services.MatchesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MatchesServiceImpl implements MatchesService {

    private final MatchesRepository matchesRepository;

    @Override
    public Matches createMatches(Matches matches) {
        return matchesRepository.save(matches);
    }

    @Override
    public Matches findById(Long idMatches) {
        Optional<Matches> matchesOptional = matchesRepository.findById(idMatches);
        if (matchesOptional.isEmpty()) throw new InvalidException(MessageConstants.NOT_FOUND);
        return matchesOptional.get();
    }
}
