package com.company.service;

import com.company.entity.RegistrationDate;
import com.company.entity.User;
import com.company.repository.RegistrationDateRepository;
import com.company.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class RegistrationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RegistrationDateRepository registrationDateRepository;

    public RegistrationService(){

    }

    public Integer registration(String login, String password, String name, String role, Integer active){
        userRepository.save(new User(name, role, login, password, active));
        Integer id = userRepository.findByLoginAndPassword(login,password).get().getId();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        registrationDateRepository.save(new RegistrationDate(id, dateFormat.format(date)));
        return id;
    }
}
