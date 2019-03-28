package com.company;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

import com.company.entity.User;
import com.company.repository.UserRepository;
import com.company.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMockitoApplicationTests {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

//    @Test
//    public void getUsersTest() {
//        when(userRepository.findAll()).
//                thenReturn(Stream.of(
//                        new User("365", "name", "role","login", 1),
//                        new User("Kolya", "USER", "return", "statement", 0),
//                        new User("Function", "COOK", "lyambda", "Inline", 1)).
//                        collect(Collectors.toList()));
//                assertEquals(3, userService.getAllUsers().size());
//    }

//    @Test
//    public void isActiveTest() {
//        User user = new User("365", "name", "role","login", 1);
//        when(userRepository.getActiveById(id)).thenReturn(user.getActive());
//    }
}
