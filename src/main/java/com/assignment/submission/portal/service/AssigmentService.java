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

import static com.assignment.submission.portal.constants.RoleConstants.ROLE_CODE_REVIEWER;

@Service
public class AssigmentService {

    @Autowired
    private AssigmentRepository assigmentRepository;


    public Assignment createAssignment(User user) {
        Assignment assignment = new Assignment();
        assignment.setStatus(AssignmentStatus.PENDING_SUBMISSION.getStatus());
        assignment.setNumber(findNextAssignmentToSubmit(user));
        assignment.setUser(user);

        return assigmentRepository.save(assignment);
    }

    private Integer findNextAssignmentToSubmit(User user) {
        Set<Assignment> assignmentByUser = assigmentRepository.findByUser(user);

        if (assignmentByUser ==null){
            return 1;
        }

        Optional<Integer> nextAssignment = assignmentByUser.stream()
                .sorted((assignment1, assignment2)
                        ->{
                    if (assignment1.getNumber() == null) return -1;
                    if (assignment2.getNumber() == null) return -1;
                    return assignment2.getNumber()
                            .compareTo(assignment1.getNumber());
                }).map(assignment ->{
                    if (assignment.getNumber() == null) return null;
                    return assignment.getNumber() + 1;
                })
                .findFirst();
        return nextAssignment.orElse(1);
    }

    public Set<Assignment> findByUser(User user){
        boolean hasCodeReviewerRole = user.getAuthorities().stream().filter(auth -> ROLE_CODE_REVIEWER.equals(auth.getAuthority()))
                .count() > 0;
        if (hasCodeReviewerRole){
            // TODO ==>> : Load assignment if you have a code_reviewer role.
            return assigmentRepository.findByCodeReviewer(user);
        }else {
            // TODO ==>> : Load assignment if you have a student role.
            return assigmentRepository.findByUser(user);
        }
    }

    public Optional<Assignment> findById(Long assignmentId) {
        return assigmentRepository.findById(assignmentId);
    }

    public Assignment updateAssignment(Long id, AssignmentDto assignmentDto) {

        Assignment assignmentToUpdate = findAssignmentById(id);
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

    private Assignment findAssignmentById(Long id){
        if (assigmentRepository.findById(id).isEmpty()){
            throw new NoSuchElementException("Assignment with id not found");
        }else {
            return assigmentRepository.findById(id).get();
        }
    }
}
