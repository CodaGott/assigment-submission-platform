package com.assignment.submission.portal.payload;

import com.assignment.submission.portal.model.Assignment;
import com.assignment.submission.portal.model.AssignmentEnum;
import com.assignment.submission.portal.model.AssignmentStatus;

public class AssignmentResponse {
    private Assignment assignment;
    private AssignmentStatus[] assignmentStatus = AssignmentStatus.values();

    //Manual mapping
  //private List<AssignmentEnumMapper> assignmentEnums = new ArrayList<>();
    private AssignmentEnum[] assignmentEnums = AssignmentEnum.values();
    public AssignmentResponse(Assignment assignment) {
        this.assignment = assignment;
//        Getting value from the manual maps.
//        Arrays.stream(AssignmentEnum.values())
//                .forEach(assignmentEnum -> {
//                    assignmentEnums.add(new AssignmentEnumMapper(assignmentEnum.getAssignmentName(), assignmentEnum.getAssignmentNum()));
//                });
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public AssignmentEnum[] getAssignmentEnums() {
        return assignmentEnums;
    }

    //    public List<AssignmentEnumMapper> getAssignmentEnums() {
//        return assignmentEnums;
//    }


    public AssignmentStatus[] getAssignmentStatus() {
        return assignmentStatus;
    }
}
