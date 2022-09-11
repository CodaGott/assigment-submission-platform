package com.assignment.submission.portal.service;

import com.assignment.submission.portal.model.Assignment;
import com.assignment.submission.portal.model.AssignmentStatus;
import com.assignment.submission.portal.model.User;
import com.assignment.submission.portal.payload.AssignmentDto;
import com.assignment.submission.portal.repository.AssigmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

@Service
public class AssigmentService {

    @Autowired
    private AssigmentRepository assigmentRepository;


    public Assignment createAssignment(User user) {
        Assignment assignment = new Assignment();
        assignment.setStatus(AssignmentStatus.PENDING_SUBMISSION.getStatus());
        assignment.setUser(user);

        return assigmentRepository.save(assignment);
    }

    public Set<Assignment> findByUser(User user){
        return assigmentRepository.findByUser(user);
    }

    public Optional<Assignment> findById(Long assignmentId) {
        return assigmentRepository.findById(assignmentId);
    }

    public Assignment updateAssignment(Long id, AssignmentDto assignmentDto) {

        Assignment assignmentToUpdate = assigmentRepository.findById(id).get();
        if (assignmentToUpdate != null){
            assignmentToUpdate.setStatus(assignmentDto.getStatus());
            assignmentToUpdate.setBranch(assignmentDto.getBranch());
            assignmentToUpdate.setGithubUrl(assignmentDto.getGithubUrl());
            assignmentToUpdate.setCodeReviewVideoUrl(assignmentDto.getCodeReviewVideoUrl());
            assignmentToUpdate.setNumber(assignmentDto.getNumber());
        }else {
            throw new NoSuchElementException("Assignment with id not found");
        }
        return assigmentRepository.save(assignmentToUpdate);
    }
}
