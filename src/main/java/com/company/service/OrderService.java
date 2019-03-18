package com.company.service;

import com.company.entity.Order;
import com.company.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class OrderService {
   @Autowired
   private OrderRepository orderRepository;

    public OrderService(){

    }

    public List<Order> getOrders(){
        Iterable<Order> orders = orderRepository.findAll();
        List<Order> ord = new ArrayList<Order>();
        orders.forEach(
                (n)->ord.add(n)
        );
        return ord;
    }

    public Integer addOrder() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        Order order = new Order(1, dateFormat.format(date).toString(), 1);
        orderRepository.save(order);
        order = orderRepository.findByDate(dateFormat.format(date).toString()).get();
        System.out.println(order.getId());
        return order.getId();
    }

    public String removeOrder(int id){

        return "deleted";
    }

    public String updateOrder(int id, String value, String pos){
        return "not ok";
    }
}
