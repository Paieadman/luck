package com.company.service;

import com.company.entity.*;
import com.company.repository.*;
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

    @Autowired
    private PhotoRepository photoRepository;

    @Autowired
    private HistoryRepository historyRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public Boolean isActive(int id) {
        if (id == 0)
            return false;
        Optional<User> user = userRepository.getActiveById(id);
        if (user.isPresent()) {
            if (user.get().getActive() == 1) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void exit(int id) {
        userRepository.updateActive(id, 0);
    }

    public DtoString getUser(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return new DtoString(user.get().getRole());
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
        if (personalDataRepository.findByUser(personalData.getId()).isPresent()) {
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

    public List<String> getPhoto() {
        Iterable<Photo> d = photoRepository.findAll();
        List<String> lst = new ArrayList<>();
        d.forEach((hey) -> {
            lst.add(hey.getPhoto());
        });
        return lst;
    }

    public int addHistory(int orderId, String customer) {
        Optional<Customer> cus = customerRepository.findByMail(customer);
        History val = historyRepository.save(new History(orderId, cus.get().getId()));
        System.out.println(val);
        return val.getId();
    }
}
