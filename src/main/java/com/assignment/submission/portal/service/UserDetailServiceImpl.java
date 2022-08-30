package com.assignment.submission.portal.service;

import com.assignment.submission.portal.model.User;
import com.assignment.submission.portal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {



    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> optionalUser = (userRepository.findByUsername(username));

        return optionalUser.orElseThrow(() -> new UsernameNotFoundException("username or password not correct"));
    }
}
