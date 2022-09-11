package com.assignment.submission.portal.repository;

import com.assignment.submission.portal.model.Assignment;
import com.assignment.submission.portal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AssigmentRepository extends JpaRepository<Assignment, Long> {
    Set<Assignment> findByUser(User user);

}
