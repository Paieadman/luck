package com.company.controller;

import com.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/active")
    public Boolean isActive(@RequestBody String id) {
        return userService.isActive(Integer.parseInt(id));
    }

    @PostMapping("/exit")
    public void exit(@RequestBody String id) {
            userService.exit(Integer.parseInt(id));
    }

    @GetMapping("/get/role/{id}")
    public String getRole(@PathVariable("id") String id) {
        return userService.getRole(Integer.parseInt(id));
    }

}
