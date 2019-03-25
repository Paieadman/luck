package com.company.service;

import com.company.entity.Order;
import com.company.entity.User;
import com.company.repository.OrderRepository;
import com.company.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    public OrderService() {

    }

    public List<Order> getOrders(String id) {
        Optional<User> user = userRepository.findById(Integer.parseInt(id));
        Iterable<Order> orders = null;
        if (user.isPresent()) {
            switch (user.get().getRole()) {
                case "ADMIN": {
                    orders = orderRepository.findAll();
                    break;
                }
                case "USER": {
                    orders = orderRepository.findAllById(Collections.singleton(Integer.parseInt(id)));
                    break;
                }
                case "COOK": {
                    orders = orderRepository.findAllById(Collections.singleton(Integer.parseInt(id)));
                    break;
                }
            }
        }

        List<Order> orderList = new ArrayList<Order>();
        orders.forEach(
                (n) -> orderList.add(n)
        );
        return orderList;
    }

    public Integer addOrder(int id) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        Iterable<User> cook = userRepository.findAllByRoleAndIsBisyAndActive();
        if (cook == null) {
            cook = userRepository.findAllByRoleAndActive();
        }
        Order order = new Order(id, dateFormat.format(date).toString(), 1, cook.iterator().next().getId());
        orderRepository.save(order);
        order = orderRepository.findByDate(dateFormat.format(date).toString()).get();
        return order.getId();
    }

    public String removeOrder(int id) {

        return "deleted";
    }

    public String updateOrder(int id, String value, String pos) {
        return "not ok";
    }

    public Integer updateStatus(Integer id) {
        orderRepository.updateStatusById(id);
        Integer i = orderRepository.findById(id).get().getStatus();
        System.out.println(i);
        return i;
    }
}
