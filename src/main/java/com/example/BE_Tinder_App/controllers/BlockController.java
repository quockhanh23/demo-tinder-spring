package com.example.BE_Tinder_App.controllers;

import com.example.BE_Tinder_App.models.Block;
import com.example.BE_Tinder_App.services.BlockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/blocks")
@RequiredArgsConstructor
public class BlockController {

    private final BlockService blockService;

    @PostMapping("/addNewBlock")
    public ResponseEntity<Object> addNewBlock(@RequestBody Block block) {
        blockService.createBlock(block);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/unBlock")
    public ResponseEntity<Object> unBlock(@RequestParam Long idBlock) {
        blockService.unBlock(idBlock);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
