package com.company.service;

import com.company.entity.Customer;
import com.company.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Integer addCustomer(Customer customer) {
        Integer id = (Integer) customerRepository.save(customer).getId();
        return id;
    }

    public Customer findCustomer(String login, String password) {
        Optional<Customer> customer = customerRepository.findByLoginAndPassword(login, password);
        if (customer.isPresent()) {
            return customer.get();
        } else {
            return null;
        }
    }
}
