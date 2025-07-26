package com.example.BE_Tinder_App.controllers;

import com.example.BE_Tinder_App.models.Block;
import com.example.BE_Tinder_App.services.BlockService;
import com.example.BE_Tinder_App.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/blocks")
@RequiredArgsConstructor
public class BlockController {

    private final BlockService blockService;

    @GetMapping("/getAllBlocked")
    public ResponseEntity<Object> getAllBlockedPage(
            @RequestParam Long idUser,
            @RequestParam(defaultValue = "0", required = false) int page,
            @RequestParam(defaultValue = "10", required = false) int size) {
        Pageable pageable = PageRequest.of(page, size);
        return new ResponseEntity<>(blockService.getAllBlockedPage(idUser, pageable), HttpStatus.OK);
    }

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
