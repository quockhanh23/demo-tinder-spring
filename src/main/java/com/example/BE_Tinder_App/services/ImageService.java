package com.example.BE_Tinder_App.services;

import com.example.BE_Tinder_App.models.Image;

public interface ImageService {

    void createImage(Image image);

    Image findById(Long idImage);
}
