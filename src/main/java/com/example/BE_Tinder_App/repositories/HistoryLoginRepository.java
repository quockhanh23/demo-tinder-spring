package com.example.BE_Tinder_App.repositories;

import com.example.BE_Tinder_App.models.HistoryLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HistoryLoginRepository extends JpaRepository<HistoryLogin, Long> {

    Optional<HistoryLogin> getFirstByIdUserLoginOrderByCreatedAtDesc(Long idUserLogin);
}
