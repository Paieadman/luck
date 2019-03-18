package com.company.controller;

import com.company.entity.AuthorizationRequest;
import com.company.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class AuthorizationController {

    @Autowired
    private AuthorizationService authorizationService;

    @PostMapping("/authorization")
    public Boolean authorization(@RequestBody AuthorizationRequest authorizationRequest){
        System.out.println(authorizationRequest);
        //return authorizationService.authorization(login,pass);
        return authorizationService.authorization(authorizationRequest.getLogin(),authorizationRequest.getPassword());
    }

}
