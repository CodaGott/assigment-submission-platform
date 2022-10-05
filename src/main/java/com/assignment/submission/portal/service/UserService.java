package com.assignment.submission.portal.service;

import com.assignment.submission.portal.model.User;
import com.assignment.submission.portal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> findUserByUsername(String username){
        return userRepository.findByUsername(username);
    }
}
