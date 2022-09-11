package com.assignment.submission.portal.payload;

import lombok.Data;

@Data
public class AssignmentDto {

    private Integer number;
    private String status;
    private String githubUrl;
    private String branch;
    private String codeReviewVideoUrl;
}
