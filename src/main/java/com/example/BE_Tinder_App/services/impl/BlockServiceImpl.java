package com.example.BE_Tinder_App.services.impl;

import com.example.BE_Tinder_App.common.BlockStatus;
import com.example.BE_Tinder_App.constant.MessageConstants;
import com.example.BE_Tinder_App.dto.UserInfo;
import com.example.BE_Tinder_App.exception.InvalidException;
import com.example.BE_Tinder_App.models.Block;
import com.example.BE_Tinder_App.repositories.BlockRepository;
import com.example.BE_Tinder_App.repositories.UserRepository;
import com.example.BE_Tinder_App.services.BlockService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BlockServiceImpl implements BlockService {

    private final BlockRepository blockRepository;
    private final UserRepository userRepository;

    @Override
    public void createBlock(Block block) {
        block.setStatus(BlockStatus.BLOCKED);
        blockRepository.save(block);
    }

    @Override
    public void unBlock(Long idBlock) {
        Block block = findById(idBlock);
        block.setStatus(BlockStatus.UN_BLOCK);
        blockRepository.save(block);
    }

    @Override
    public Block findById(Long idBlock) {
        Optional<Block> blockOptional = blockRepository.findById(idBlock);
        if (blockOptional.isEmpty()) throw new InvalidException(MessageConstants.NOT_FOUND);
        return blockOptional.get();
    }

    @Override
    public Page<UserInfo> getAllBlockedPage(Long idUserLogin, Pageable pageable) {
        Page<UserInfo> page = new PageImpl<>(List.of());
        List<Block> blockList = blockRepository.getAllByIdUserActionAndStatus(idUserLogin, BlockStatus.BLOCKED);
        if (!CollectionUtils.isEmpty(blockList)) {
            page = userRepository.findAllByIdIn
                    (pageable, blockList.stream().map(Block::getIdUserAffected).collect(Collectors.toSet()));
        }
        return page;
    }
}
