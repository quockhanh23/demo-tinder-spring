package com.example.BE_Tinder_App.controllers;

import com.example.BE_Tinder_App.models.DislikeUser;
import com.example.BE_Tinder_App.models.DropHeartMessage;
import com.example.BE_Tinder_App.models.LikeUser;
import com.example.BE_Tinder_App.repositories.DislikeUserRepository;
import com.example.BE_Tinder_App.repositories.DropHeartRepository;
import com.example.BE_Tinder_App.repositories.LikeUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/actions")
@RequiredArgsConstructor
public class UserActionController {

    private final LikeUserRepository likeUserRepository;
    private final DislikeUserRepository dislikeUserRepository;
    private final DropHeartRepository dropHeartRepository;

    @PostMapping("/like")
    public ResponseEntity<Object> actionLike(@RequestParam Long idUserAction, @RequestParam Long idUserAffected) {
        LikeUser likeUser = new LikeUser();
        likeUser.setIdUserAction(idUserAction);
        likeUser.setIdUserAffected(idUserAffected);
        likeUserRepository.save(likeUser);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/dislike")
    public ResponseEntity<Object> actionDislike(@RequestParam Long idUserAction, @RequestParam Long idUserAffected) {
        DislikeUser dislikeUser = new DislikeUser();
        dislikeUser.setIdUserAction(idUserAction);
        dislikeUser.setIdUserAffected(idUserAffected);
        dislikeUserRepository.save(dislikeUser);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/dropHeartMessage")
    public ResponseEntity<Object> actionDropHeart(@RequestParam Long idUserAction, @RequestParam Long idUserAffected) {
        DropHeartMessage dropHeartMessage = new DropHeartMessage();
        dropHeartMessage.setIdUserDropHeart(idUserAction);
        dropHeartMessage.setIdUserReceive(idUserAffected);
        dropHeartRepository.save(dropHeartMessage);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
