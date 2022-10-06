package com.assignment.submission.portal.service;

import com.assignment.submission.portal.model.Assignment;
import com.assignment.submission.portal.model.Comment;
import com.assignment.submission.portal.model.User;
import com.assignment.submission.portal.payload.CommentDto;
import com.assignment.submission.portal.repository.AssigmentRepository;
import com.assignment.submission.portal.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private AssigmentRepository assignmentRepository;

    @Override
    public Comment create(CommentDto commentDto, User user) {
        Assignment assignment = assignmentRepository.getById(commentDto.getAssignmentId());
        Comment comment = new Comment();
        comment.setText(commentDto.getText());
        comment.setCreatedBy(user);
        comment.setAssignment(assignment);
        comment.setCreatedDate(LocalDateTime.now());
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> getAll() {
        return null;
    }

    @Override
    public Comment getAComment(Long id) {
        return null;
    }

    @Override
    public Comment updateComment(CommentDto commentDto) {
        return null;
    }

    @Override
    public void deleteComment(Long id) {

    }
}
