package com.assignment.submission.portal.model;

import javax.persistence.*;

@Entity
public class Assignment {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Integer number;
//    private String name;
//    @Enumerated
//    private AssignmentEnum assignmentEnum;
    private String status;
    private String githubUrl;
    private String branch;
    private String codeReviewVideoUrl;
    // Can't have assignment without a user.
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private User codeReviewer;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGithubUrl() {
        return githubUrl;
    }

    public void setGithubUrl(String githubUrl) {
        this.githubUrl = githubUrl;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getCodeReviewVideoUrl() {
        return codeReviewVideoUrl;
    }

    public void setCodeReviewVideoUrl(String codeReviewVideoUrl) {
        this.codeReviewVideoUrl = codeReviewVideoUrl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public User getCodeReviewer() {
        return codeReviewer;
    }

    public void setCodeReviewer(User codeReviewer) {
        this.codeReviewer = codeReviewer;
    }
}
