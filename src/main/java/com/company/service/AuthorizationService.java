package com.company.service;

import com.company.entity.User;
import com.company.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class AuthorizationService {
    @Autowired
    private UserRepository userRepository;

    public AuthorizationService() {
    }

    public Integer authorization(String login, String pass) {
        Optional<User> user = userRepository.findByLoginAndPassword(login, pass);
        if (user.isPresent()) {
            userRepository.updateActive(user.get().getId(), 1);
            return user.get().getId();
        }
        return 0;
    }
}
