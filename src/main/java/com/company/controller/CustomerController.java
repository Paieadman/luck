package com.company.controller;

import com.company.entity.AuthorizationRequest;
import com.company.entity.Customer;
import com.company.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/customer/registration")
    public Integer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @PostMapping("/customer/authorization")
    public Customer authorizeCustomer(@RequestBody AuthorizationRequest authorizationRequest) {
        return customerService.findCustomer(authorizationRequest.getLogin(), authorizationRequest.getPassword());
    }
}
