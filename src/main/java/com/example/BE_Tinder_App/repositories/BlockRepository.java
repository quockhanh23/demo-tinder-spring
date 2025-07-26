package com.example.BE_Tinder_App.repositories;

import com.example.BE_Tinder_App.common.BlockStatus;
import com.example.BE_Tinder_App.models.Block;
import com.example.BE_Tinder_App.models.LikeUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlockRepository extends JpaRepository<Block, Long> {

    List<Block> getAllByIdUserActionAndStatus(Long idUser, BlockStatus status);
}
