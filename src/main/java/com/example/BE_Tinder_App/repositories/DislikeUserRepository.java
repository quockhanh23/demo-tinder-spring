package com.example.BE_Tinder_App.repositories;

import com.example.BE_Tinder_App.models.DislikeUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DislikeUserRepository extends JpaRepository<DislikeUser, Long> {
}
