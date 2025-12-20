package com.example.BE_Tinder_App.repositories;

import com.example.BE_Tinder_App.models.Setting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SettingRepository extends JpaRepository<Setting, Long> {

    Setting findByIdUser(Long idUser);
}
