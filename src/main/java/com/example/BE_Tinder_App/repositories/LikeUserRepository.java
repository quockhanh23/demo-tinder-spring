package com.example.BE_Tinder_App.repositories;

import com.example.BE_Tinder_App.models.LikeUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeUserRepository extends JpaRepository<LikeUser, Long> {
}
