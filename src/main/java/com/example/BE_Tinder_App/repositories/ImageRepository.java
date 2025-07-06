package com.example.BE_Tinder_App.repositories;

import com.example.BE_Tinder_App.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
}
