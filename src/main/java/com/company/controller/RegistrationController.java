package com.company.controller;

import com.company.entity.AuthorizationRequest;
import com.company.entity.User;
import com.company.service.AuthorizationService;
import com.company.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/registration")
    public Integer registration(@RequestBody User user){
        return registrationService.registration(user.getName(), user.getRole(), user.getLogin(), user.getPassword(), user.getActive(), user.getIsBisy());
    }
}