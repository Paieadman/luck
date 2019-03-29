package com.company.service;

import com.company.entity.Order;
import com.company.entity.PersonalData;
import com.company.entity.User;
import com.company.repository.PersonalDataRepository;
import com.company.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PersonalDataRepository personalDataRepository;

    public Boolean isActive(int id) {
        if (id == 0)
            return false;
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

    public User getUser(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }

    public PersonalData getPersonalData(int id) {
        Optional<PersonalData> pd = personalDataRepository.findByUser(id);
        if (pd.isPresent()) {
            return pd.get();
        } else {
            return new PersonalData();
        }
    }

    public void changeInfo(PersonalData personalData) {
        if(personalDataRepository.findById(personalData.getId()).isPresent()) {
            personalDataRepository.updatePersonalData(personalData.getId(),
                    personalData.getUser(), personalData.getFirstname(),
                    personalData.getSurname(), personalData.getAge(), personalData.getMobileNumber(),
                    personalData.getAvatar(), personalData.getSex());
        } else {
            personalDataRepository.save(personalData);
        }
    }

    public List<User> getAllUsers() {
        Iterable<User> users = userRepository.findAll();
        List<User> userList = new ArrayList<>();
        users.forEach(
                (user) -> userList.add(user)
        );
        return userList;
    }
}
