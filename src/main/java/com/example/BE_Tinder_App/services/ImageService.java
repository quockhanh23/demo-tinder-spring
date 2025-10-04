package com.example.BE_Tinder_App.services;

import com.example.BE_Tinder_App.dto.UserInfo;
import com.example.BE_Tinder_App.models.Image;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ImageService {

    Image createImage(Image image);

    Image findById(Long idImage);

    void updateStatusImage(String status, Long idImage);

    Page<UserInfo> getAllImagePage(Pageable pageable, Long idUser);
}
