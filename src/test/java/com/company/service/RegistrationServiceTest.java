package com.company.service;

import com.company.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.Assert.*;

public class RegistrationServiceTest {

    @Autowired
    private RegistrationService registrationService;

    @MockBean
    private UserRepository userRepository;

    public void registrationTest() {

    }
}