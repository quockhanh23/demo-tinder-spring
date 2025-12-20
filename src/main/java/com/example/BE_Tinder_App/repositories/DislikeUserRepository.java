package com.example.BE_Tinder_App.repositories;

import com.example.BE_Tinder_App.models.DislikeUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DislikeUserRepository extends JpaRepository<DislikeUser, Long> {
    List<DislikeUser> getAllByIdUserAction(Long idUser);
}
