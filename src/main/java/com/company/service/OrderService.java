package com.company.service;

import com.company.entity.Card;
import com.company.entity.Dish;
import com.company.entity.Order;
import com.company.entity.User;
import com.company.repository.CardRepository;
import com.company.repository.DishRepository;
import com.company.repository.OrderRepository;
import com.company.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class OrderService {
    private final static int DEFAULT_ORDER_STATUS = 1;
    private final static int DEFAULT_COOK_ID = 0;


    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private DishRepository dishRepository;

    public OrderService() {

    }

    public Integer addOrder(int id) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        orderRepository.save(new Order(id, dateFormat.format(date).toString(), DEFAULT_ORDER_STATUS, DEFAULT_COOK_ID));
        return orderRepository.findByDate(dateFormat.format(date).toString()).get().getId();
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

    public List<Order> getOrders(String id) {
        Optional<User> user = userRepository.findById(Integer.parseInt(id));
        Iterable<Order> orders = null;
        if (user.isPresent()) {
            switch (user.get().getRole()) {
                case "ADMIN": {
                    orders = orderRepository.findAllProcessingOrders();
                    break;
                }
                case "USER": {
                    orders = orderRepository.findAllProcessingOrdersById(Integer.parseInt(id));
                    break;
                }
                case "COOK": {
                    orders = orderRepository.findProcessingOrdersByCook(Integer.parseInt(id));
                    break;
                }
                default: {
                    System.out.println("role not found");
                }
            }
        }

        List<Order> orderList = new ArrayList<Order>();
        orders.forEach(
                (n) -> orderList.add(n)
        );
        return orderList;
    }

    public List<Order> getPerformed(String id) {
        Optional<User> user = userRepository.findById(Integer.parseInt(id));
        Iterable<Order> orders = null;
        if (user.isPresent()) {
            switch (user.get().getRole()) {
                case "ADMIN": {
                    orders = orderRepository.findAllPerformed();
                    break;
                }
                case "USER": {
                    orders = orderRepository.findAllPerformedForUser(Integer.parseInt(id));
                    break;
                }
                case "COOK": {
                    orders = orderRepository.findAllPerformedForCook(Integer.parseInt(id));
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

    public List<Order> getOrdersForId(String id) {
        Optional<User> user = userRepository.findById(Integer.parseInt(id));
        Iterable<Order> orders = null;
        if (user.isPresent()) {
            switch (user.get().getRole()) {
                case "ADMIN": {
                    orders = orderRepository.findAll();
                    break;
                }
                case "USER": {
                    orders = orderRepository.findAllForUser(Integer.parseInt(id));
                    break;
                }
                case "COOK": {
                    orders = orderRepository.findAllForCook(Integer.parseInt(id));
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

    public List<Dish> getDishesFromOrder(int id) {
        List<Dish> dishes = new ArrayList<Dish>();
        List<Card> cards = cardRepository.findAllByOrder(id);
        cards.forEach((Card card) -> {
            dishes.add(dishRepository.findById(card.getId()).get());
        });
        return dishes;
    }

    public Integer getCurrentOrder(int id) {
        Optional<Order> order = orderRepository.findOrderByIdAndStatus(id, 1);
        if (order.isPresent()) {
            return order.get().getId();
        } else {
            return 0;
        }
    }
}
