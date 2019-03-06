package com.company.controller;

import com.company.entity.*;
import com.company.repository.OrdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
public class TestController {
    @Autowired
//    private OrdRepository orderRepository;
    private OrdRepository orderRepository;

//    @RequestMapping("/")
//    public Iterable<Ord> test(){
//        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//        Date date = new Date();
//        return orderRepository.findAll();
//        //orderRepository.save(new Ord( 1,dateFormat.format(date).toString(),2,"1,2,3,4,5"));
//    }
    @RequestMapping("/")
    public Iterable<Ord> test(){
        return orderRepository.findAll();
    }
}
