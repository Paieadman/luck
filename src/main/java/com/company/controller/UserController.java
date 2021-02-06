package com.company.controller;

import com.company.entity.*;
import com.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.smartcardio.Card;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/active/{id}")
    public Boolean isActive(@PathVariable("id") String id) {
        return userService.isActive(Integer.parseInt(id));
    }

    @PostMapping("/exit")
    public void exit(@RequestBody String id) {
        userService.exit(Integer.parseInt(id));
    }

    @RequestMapping("/get/role/{id}")
    public DtoString getUser(@PathVariable("id") String id) {
        return userService.getUser(Integer.parseInt(id));
    }

    @PostMapping("/get/personal/data")
    public PersonalData getPersonalData(@RequestBody String id) {
        return userService.getPersonalData(Integer.parseInt(id));
    }

    @PostMapping("/change/personal/data")
    public void changeInfo(@RequestBody PersonalData personalData) {
        userService.changeInfo(personalData);
    }

    @RequestMapping("/get/photo")
    public List<String> getPhoto() {
        return userService.getPhoto();
    }

    @PostMapping("/add/history")
    public int addHistory(@RequestBody AuthorizationRequest authorizationRequest ) { return userService.addHistory(Integer.parseInt(authorizationRequest.getLogin()), authorizationRequest.getPassword());}

}
