package com.company.service;

import com.company.entity.User;
import com.company.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

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
    @Test
    public void getUsersTest() {
        when(userRepository.findAll()).
                thenReturn(Stream.of(
                        new User("365", "name", "role","login", 1),
                        new User("Kolya", "USER", "return", "statement", 0),
                        new User("Function", "COOK", "lyambda", "Inline", 1)).
                        collect(Collectors.toList()));
        assertEquals(3, userService.getAllUsers().size());
    }
}