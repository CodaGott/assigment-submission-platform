package com.assignment.submission.portal.web;

import com.assignment.submission.portal.model.Assignment;
import com.assignment.submission.portal.model.User;
import com.assignment.submission.portal.payload.AssignmentDto;
import com.assignment.submission.portal.payload.AssignmentResponse;
import com.assignment.submission.portal.service.AssigmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("api/assignments")
@Slf4j
public class AssignmentController {

    @Autowired
    private AssigmentService assigmentService;

    @PostMapping("")
    public ResponseEntity<?> createAssignment(@AuthenticationPrincipal User user){
        Assignment newAssignment = assigmentService.createAssignment(user);
        return new ResponseEntity<>(newAssignment, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> getAssignments(@AuthenticationPrincipal User user){
        Set<Assignment> assignmentByUser = assigmentService.findByUser(user);
        log.info("Assignments: {}", assigmentService.findByUser(user).toString());
        return ResponseEntity.ok(assignmentByUser);
    }

    @GetMapping("{assignmentId}")
    public ResponseEntity<?> getAssignment(@PathVariable Long assignmentId,  @AuthenticationPrincipal User user){
        Optional<Assignment> optionalAssignment = assigmentService.findById(assignmentId);
        AssignmentResponse assignmentResponse = new AssignmentResponse(optionalAssignment.orElse(new Assignment()));
        return ResponseEntity.ok(assignmentResponse);
    }

    @PutMapping("{assignmentId}")
    public ResponseEntity<?> updateAssignment(@PathVariable Long assignmentId, @RequestBody AssignmentDto assignment, @AuthenticationPrincipal User user){
        Assignment updatedAssignment = assigmentService.updateAssignment(assignmentId, assignment);
        return ResponseEntity.ok(updatedAssignment);
    }
}
