package com.assignment.submission.portal.model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum AssignmentEnum {

    ASSIGNMENT_1(1, "First assignment"),
    ASSIGNMENT_2(2, "Second Assignment"),
    ASSIGNMENT_3(3, "Third Assignment"),
    ASSIGNMENT_4(4, "Fourth Assignment");
// TODO   ASSIGNMENT_5(5),
//    ASSIGNMENT_6(6),
//    ASSIGNMENT_7(7),
//    ASSIGNMENT_8(8),
//    ASSIGNMENT_9(9),
//    ASSIGNMENT_10(10),
//    ASSIGNMENT_11(11),
//    ASSIGNMENT_12(12),
//    ASSIGNMENT_13(13),
//    ASSIGNMENT_14(14),
//    ASSIGNMENT_15(15);

    //TODO This ENUM type is used when you know beforehand how many
    // assignments that is needed and expected.
    // This way the front-end will have like a drop-down where
    // the user can select which assignment he/she is submitting.

    private final Integer assignmentNum;
    private final String assignmentName;

    AssignmentEnum(Integer assignmentNum, String assignmentName){
        this.assignmentNum = assignmentNum;
        this.assignmentName = assignmentName;
    }

    public Integer getAssignmentNum() {
        return assignmentNum;
    }

    public String getAssignmentName() {
        return assignmentName;
    }
}
