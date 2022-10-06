package com.assignment.submission.portal.web;

import com.assignment.submission.portal.model.User;
import com.assignment.submission.portal.payload.CommentDto;
import com.assignment.submission.portal.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("")
    public ResponseEntity<?> createComment(@RequestBody CommentDto commentDto, @AuthenticationPrincipal User user){
        return new ResponseEntity<>(commentService.create(commentDto, user), HttpStatus.CREATED);
    }
}
