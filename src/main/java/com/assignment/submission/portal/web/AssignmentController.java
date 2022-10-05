package com.assignment.submission.portal.web;

import com.assignment.submission.portal.model.Assignment;
import com.assignment.submission.portal.model.User;
import com.assignment.submission.portal.payload.AssignmentDto;
import com.assignment.submission.portal.payload.AssignmentResponse;
import com.assignment.submission.portal.service.AssigmentService;
import com.assignment.submission.portal.service.UserService;
import com.assignment.submission.portal.util.AuthorityUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

import static com.assignment.submission.portal.constants.RoleConstants.ROLE_CODE_REVIEWER;

@RestController
@RequestMapping("api/assignments")
@Slf4j
public class AssignmentController {

    @Autowired
    private AssigmentService assigmentService;

    @Autowired
    private UserService userService;

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

        if (assignment.getCodeReviewer() != null){
            User codeReviewer = assignment.getCodeReviewer();
            codeReviewer = userService.findUserByUsername(codeReviewer.getUsername()).orElse(new User());

            if (AuthorityUtil.hasRole(ROLE_CODE_REVIEWER, codeReviewer)){
                assignment.setCodeReviewer(codeReviewer);
            }
        }
        Assignment updatedAssignment = assigmentService.updateAssignment(assignmentId, assignment);
        return ResponseEntity.ok(updatedAssignment);
    }
}
