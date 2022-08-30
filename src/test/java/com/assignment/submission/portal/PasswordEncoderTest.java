package com.assignment.submission.portal;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderTest {

    @Test
    void encode_password(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("asdfasdf"));
    }
}
