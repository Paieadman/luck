package com.company.service;

import com.company.entity.User;
import com.company.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class RegistrationService {

    @Autowired
    private UserRepository userRepository;

    public RegistrationService() {
    }

    public Integer registration(String login, String password, String name, String role, Integer active) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        User user = userRepository.save(new User(name, role, login, password, active, dateFormat.format(new Date())));
        return user.getId();
    }
}
