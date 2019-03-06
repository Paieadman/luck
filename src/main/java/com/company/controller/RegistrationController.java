package com.company.controller;

import com.company.service.AuthorizationService;
import com.company.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @RequestMapping("/registration")
    public String registration(String login, String pass){
        return registrationService.registration(login,pass);
    }
}