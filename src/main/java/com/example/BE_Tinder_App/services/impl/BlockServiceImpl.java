package com.example.BE_Tinder_App.services.impl;

import com.example.BE_Tinder_App.constant.MessageConstants;
import com.example.BE_Tinder_App.exeption.InvalidException;
import com.example.BE_Tinder_App.models.Block;
import com.example.BE_Tinder_App.repositories.BlockRepository;
import com.example.BE_Tinder_App.services.BlockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BlockServiceImpl implements BlockService {

    private final BlockRepository blockRepository;

    @Override
    public void createBlock(Block block) {
        blockRepository.save(block);
    }

    @Override
    public void unBlock(Long idBlock) {
        Block block = findById(idBlock);
        blockRepository.save(block);
    }

    @Override
    public Block findById(Long idBlock) {
        Optional<Block> blockOptional = blockRepository.findById(idBlock);
        if (blockOptional.isEmpty()) throw new InvalidException(MessageConstants.NOT_FOUND);
        return blockOptional.get();
    }
}
