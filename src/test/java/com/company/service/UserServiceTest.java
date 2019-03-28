package com.company.service;

import com.company.entity.PersonalData;
import com.company.entity.User;
import com.company.repository.PersonalDataRepository;
import com.company.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;
    
    @MockBean
    private UserRepository userRepository;

    @MockBean
    private PersonalDataRepository personalDataRepository;

    @Test
    public void getUsersTest() {
        when(userRepository.findAll()).
                thenReturn(Stream.of(
                        new User("365", "name", "role", "login", 1),
                        new User("Kolya", "USER", "return", "statement", 0),
                        new User("Function", "COOK", "lyambda", "Inline", 1)).
                        collect(Collectors.toList()));
        assertEquals(3, userService.getAllUsers().size());
    }

    @Test
    public void getPersonalData() {
        PersonalData pd = new PersonalData(1, "custom", "custom", 1, "custom", "custom", "custom");
        when(personalDataRepository.findByUser(1)).thenReturn(Optional.of(pd));
        assertEquals(pd, userService.getPersonalData(1));
    }

    @Test
    public void isActiveTest() {
        User user = new User("365", "name", "role", "login", 1);
        when(userRepository.getActiveById(user.getId())).thenReturn(Optional.of(user));
        assertEquals(false, userService.isActive(user.getId()));
    }

    @Test
    public void getRoleTest() {
        User user = new User("365", "ADMIN", "role", "login", 1);
        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        assertEquals("ADMIN", userService.getRole(user.getId()));
    }
}