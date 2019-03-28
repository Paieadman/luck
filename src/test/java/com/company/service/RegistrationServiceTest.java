package com.company.service;

import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

import com.company.entity.User;
import com.company.repository.UserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.Assert.*;

public class RegistrationServiceTest {

    @Autowired
    private RegistrationService registrationService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void registrationTest() {
        User user = new User("365", "name", "role","login", 1);
        when(userRepository.save(user)).thenReturn(user);
        when(userRepository.findByLoginAndPassword(user.getLogin(), user.getPassword())).thenReturn(Optional.of(user));
        assertEquals(user.getId(), registrationService.registration("365", "name", "role","login", 1));
    }
}