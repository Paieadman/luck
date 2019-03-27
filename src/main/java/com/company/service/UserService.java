package com.company.service;

import com.company.entity.PersonalData;
import com.company.entity.User;
import com.company.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Boolean isActive(int id) {
        Optional<User> user =  userRepository.getActiveById(id);
        if (user.isPresent()) {
            if (user.get().getActive()==1) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void exit(int id) {
        userRepository.updateActive(id,0);
    }

    public String getRole(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get().getRole();
        }
        return "no";
    }

    public PersonalData getPersonalData(int id) {

    }
}
