package com.assignment.submission.portal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
@Data
public class Comment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime createdDate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User createdBy;
    @JsonIgnore
    @ManyToOne
    private Assignment assignment;
    @Column(columnDefinition = "TEXT")
    private String text;
}
