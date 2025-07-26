package com.example.BE_Tinder_App.services;

import com.example.BE_Tinder_App.models.Image;

public interface ImageService {

    Image createImage(Image image);

    Image findById(Long idImage);

    void updateStatusImage(String status, Long idImage);
}
