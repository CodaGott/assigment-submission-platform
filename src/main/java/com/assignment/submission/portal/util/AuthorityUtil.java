package com.assignment.submission.portal.util;

import com.assignment.submission.portal.model.User;

public class AuthorityUtil {

    public static boolean hasRole(String role, User user){
        return user.getAuthorities()
                .stream()
                .filter(auth -> auth.getAuthority().equals(role))
                .count() > 0;
    }
}
