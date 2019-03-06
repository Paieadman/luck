package com.company.service;

import com.company.entity.Ord;
import com.company.repository.OrdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderService {
   @Autowired
   private OrdRepository orderRepository;

    public OrderService(){

    }

    public List<Ord> getOrders(){
        Iterable<Ord> orders = orderRepository.findAll();
        List<Ord> ord = new ArrayList<Ord>();
        orders.forEach(
                (n)->ord.add(n)
        );
        return ord;
    }

    public void addOrder(Ord order) {
        orderRepository.save(order);
    }

    public String removeOrder(int id){

        return "deleted";
    }

    public String updateOrder(int id, String value, String pos){
        return "not ok";
    }
}
