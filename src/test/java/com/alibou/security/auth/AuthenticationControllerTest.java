package com.alibou.security.auth;

import com.alibou.security.SecurityApplication;
import com.alibou.security.auth.util.AuthenticationRequest;
import com.alibou.security.auth.util.AuthenticationResponse;
import com.alibou.security.auth.util.RegisterRequest;
import com.alibou.security.auth.util.RegistrationResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(classes = {SecurityApplication.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AuthenticationControllerTest {

    @Autowired
    private AuthenticationController controller;

    private RegisterRequest request;


    @BeforeAll
    void setUp() {
        request = RegisterRequest
                .builder()
                .email("aliou-conde@gmx.de")
                .firstname("Aliou")
                .lastname("Condé")
                .password("19A12iou#")
                .build();


    }

    @Test
    @Disabled
    void registrationTest() {

        //When
        ResponseEntity<RegistrationResponse> register = controller.register(request);
        int statusCode = register.getStatusCode().value();

        //Then
        assertThat(statusCode).isEqualTo(200);

    }

    @Test
    void authenticationTest() {
        //Given
        AuthenticationRequest request = AuthenticationRequest
                .builder()
                .email("aliou-conde@gmx.de")
                .password("19A12iou#")
                .build();

        //When
        ResponseEntity<AuthenticationResponse> register = controller.authenticate(request);
        int statusCode = register.getStatusCode().value();

        //Then
        assertThat(statusCode).isEqualTo(200);

    }
}