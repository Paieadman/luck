package com.company.service;

import com.company.entity.User;
import com.company.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Controller
public class RegistrationService {

    @Autowired
    private UserRepository userRepository;

    public RegistrationService(){

    }

    public Integer registration(String login, String password, String name, String role, Integer active, Integer isBisy){
        userRepository.save(new User(name, role, login, password, active, isBisy));
        return userRepository.findByLoginAndPassword(login,password).get().getId();
    }
}
