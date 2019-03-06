package com.company.controller;

import com.company.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class AuthorizationController {

    @Autowired
    private AuthorizationService authorizationService;

    @RequestMapping("/authorization")
    public String authorization(String login, String pass){
        return authorizationService.authorization(login,pass);
    }

}
