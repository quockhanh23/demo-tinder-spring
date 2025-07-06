package com.example.BE_Tinder_App.repositories;

import com.example.BE_Tinder_App.models.DropHeartMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DropHeartRepository extends JpaRepository<DropHeartMessage, Long> {
}
