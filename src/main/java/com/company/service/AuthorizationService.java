package com.company.service;

import com.company.entity.User;
import com.company.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Controller
public class AuthorizationService {
    public AuthorizationService() {

    }

//    @Autowired
//    private UserRepository userRepository;

    public String authorization(String login, String pass) {
//        Object user = userRepository.findByNameAndPassword(login, pass);
//        if(userRepository.equals(null)) {
//            return "hello";
//        } else {
//            return "ok";
//        }
//    }
        return "hi";
    }
}
