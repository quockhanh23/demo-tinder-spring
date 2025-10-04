package com.example.BE_Tinder_App.services.impl;

import com.example.BE_Tinder_App.constant.MessageConstants;
import com.example.BE_Tinder_App.dto.UserInfo;
import com.example.BE_Tinder_App.exeption.InvalidException;
import com.example.BE_Tinder_App.models.Image;
import com.example.BE_Tinder_App.repositories.ImageRepository;
import com.example.BE_Tinder_App.services.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    @Override
    public Image createImage(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public Image findById(Long idImage) {
        Optional<Image> imageOptional = imageRepository.findById(idImage);
        if (imageOptional.isEmpty()) throw new InvalidException(MessageConstants.NOT_FOUND);
        return imageOptional.get();
    }

    @Override
    public void updateStatusImage(String status, Long idImage) {
        Image image = findById(idImage);
        image.setStatus(status);
        imageRepository.save(image);
    }

    @Override
    public Page<UserInfo> getAllImagePage(Pageable pageable, Long idUser) {
        return null;
    }
}
