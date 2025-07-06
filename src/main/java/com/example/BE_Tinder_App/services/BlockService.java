package com.example.BE_Tinder_App.services;

import com.example.BE_Tinder_App.models.Block;

public interface BlockService {

    void createBlock(Block block);

    void unBlock(Long idBlock);

    Block findById(Long idBlock);
}
