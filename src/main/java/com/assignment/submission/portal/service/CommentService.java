package com.assignment.submission.portal.service;

import com.assignment.submission.portal.model.Comment;
import com.assignment.submission.portal.model.User;
import com.assignment.submission.portal.payload.CommentDto;

import java.util.List;
import java.util.Set;


public interface CommentService {
    Comment create(CommentDto commentDto, User user);
    List<Comment> getAll();
    Set<Comment> getAComment(Long id);
    Comment updateComment(CommentDto commentDto);
    void deleteComment(Long id);
}
