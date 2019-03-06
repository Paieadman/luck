package com.company.service;

import com.company.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Controller
public class AuthorizationService {
    public AuthorizationService(){

    }
    @Autowired
    private UserRepository userRepository;

    public String authorization(String login, String pass){
        return "Wrong info";
    }

}
