package com.assignment.submission.portal.model;

import javax.persistence.*;

@Entity
public class Assignment {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String status;
    private String gitUrl;
    private String branch;
    private String codeReviewVideoUrl;
    // Can't have assignment without a user.
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User user;
    // TODO private User assignedTo;


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

    public String getGitUrl() {
        return gitUrl;
    }

    public void setGitUrl(String gitUrl) {
        this.gitUrl = gitUrl;
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
}
