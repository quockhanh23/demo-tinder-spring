package com.example.BE_Tinder_App.services.impl;

import com.example.BE_Tinder_App.common.LoginStatus;
import com.example.BE_Tinder_App.models.HistoryLogin;
import com.example.BE_Tinder_App.repositories.HistoryLoginRepository;
import com.example.BE_Tinder_App.services.HistoryLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HistoryLoginServiceImpl implements HistoryLoginService {

    private final HistoryLoginRepository historyLoginRepository;

    @Override
    public void createLog(Long idUserLogin) {
        HistoryLogin historyLogin = new HistoryLogin();
        historyLogin.setCreatedAt(new Date());
        historyLogin.setStatus(LoginStatus.ONLINE);
        historyLogin.setIdUserLogin(idUserLogin);
        historyLoginRepository.save(historyLogin);
    }

    @Override
    public void updateLog(Long idUserLogin) {
        Optional<HistoryLogin> historyLoginOptional = historyLoginRepository
                .getFirstByIdUserLoginOrderByCreatedAtDesc(idUserLogin);
        if (historyLoginOptional.isPresent()) {
            historyLoginOptional.get().setStatus(LoginStatus.OFFLINE);
            historyLoginOptional.get().setUpdatedAt(new Date());
            historyLoginRepository.save(historyLoginOptional.get());
        }
    }
}
