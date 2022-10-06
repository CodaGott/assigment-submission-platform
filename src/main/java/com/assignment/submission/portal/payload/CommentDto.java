package com.assignment.submission.portal.payload;

import com.assignment.submission.portal.model.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentDto {
    private LocalDateTime createdDate;
    private Long assignmentId;
    private String text;
    private User user;
}
