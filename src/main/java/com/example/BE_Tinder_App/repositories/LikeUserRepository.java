package com.example.BE_Tinder_App.repositories;

import com.example.BE_Tinder_App.models.LikeUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeUserRepository extends JpaRepository<LikeUser, Long> {

    List<LikeUser> getAllByIdUserAction(Long idUser);
}
