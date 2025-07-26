package com.example.BE_Tinder_App.services;

import com.example.BE_Tinder_App.dto.UserInfo;
import com.example.BE_Tinder_App.models.Block;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlockService {

    void createBlock(Block block);

    void unBlock(Long idBlock);

    Block findById(Long idBlock);

    Page<UserInfo> getAllBlockedPage(Long idUserLogin, Pageable pageable);
}
