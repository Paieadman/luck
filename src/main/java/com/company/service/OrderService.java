package com.company.service;

import com.company.entity.*;
import com.company.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class OrderService {
    private final static int DEFAULT_ORDER_STATUS = 1;
    private final static int DEFAULT_COOK_ID = 0;
    private final static int DEFAULT_DELIVERY_USER = 0;

    @Autowired
    private CardService cardService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private HistoryRepository historyRepository;

    public OrderService() {
    }

    public Integer addOrder(int id) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        Order order = new Order(id, dateFormat.format(date).toString(), DEFAULT_ORDER_STATUS, DEFAULT_COOK_ID);
        orderRepository.save(order);
        return order.getId();
    }

    public Integer updateStatus(Integer id, Integer cook) {
        Integer updatedOrder = orderRepository.updateStatusById(id, cook);
        return updatedOrder;
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

        List<Order> orderList = new ArrayList<>();
        orders.forEach(
                (order) -> orderList.add(order)
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
                (order) -> orderList.add(order)
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
                (order) -> orderList.add(order)
        );
        return orderList;
    }

    public List<Dish> getDishesFromOrder(int id) {
        List<Dish> dishes = new ArrayList<Dish>();
        List<Cart> carts = cartRepository.findAllByOrder(id);
        carts.forEach((Cart cart) -> {
            dishes.add(dishRepository.findById(cart.getId()).get());
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

    public List<Long> getNumberOfOrders(int id) {
        List<Long> count = new ArrayList<Long>();
        count.add(countNumberOfCurrentOrders(id));
        count.add(countNumberOfPerformedOrders(id));
        count.add(countNumberOfOrders(id));
        return count;
    }

    private Long countNumberOfCurrentOrders(Integer id) {
        return orderRepository.countNumberOfCurrentOrders(id).get();
    }

    private Long countNumberOfOrders(Integer id) {
        return orderRepository.countNumberOfOrders(id).get();
    }

    private Long countNumberOfPerformedOrders(Integer id) {
        return orderRepository.countNumberOfPerformedOrders(id).get();
    }

    public void confirm(int id) {
        orderRepository.updateOrderToConfirmed(id);
    }

    public List<Order> getOrdersForCook(String id) {
        Iterable<Order> orders = orderRepository.findAllForCookWithStatus(Integer.parseInt(id));
        List<Order> orderList = new ArrayList<Order>();
        orders.forEach(
                (order) -> orderList.add(order)
        );
        return orderList;
    }

    public int takeDelivery(DeliveryObject deliveryObject) {
        int id = addOrder(DEFAULT_DELIVERY_USER);
        orderRepository.updateOrderToConfirmed(id);
        for (Dish i : deliveryObject.getDelivery()) {
            cardService.addInBin(id, i.getId());
        }
        locationRepository.save(new Location(deliveryObject.getStreet(), deliveryObject.getHouse(),
                deliveryObject.getFlat(), (int) id));
        return id;
    }

    public List<Integer> getHistory(String mail) {
        Customer c = customerRepository.findByMail(mail).get();
        System.out.println(c.getId());
        Iterable<History> h = historyRepository.findAllByUser(c.getId());
        List<Integer> history = new ArrayList<>();//list of id of orders
        h.forEach((elem) -> {
            history.add(elem.getOrder());
        });
        System.out.println(history);
        return history;
    }

    public List<Order> getOrdersForDeliver(String id) {
        Iterable<Order> orders = orderRepository.findAllForDeliver(Integer.parseInt(id));
        List<Order> orderList = new ArrayList<Order>();
        orders.forEach(
                (order) -> orderList.add(order)
        );
        return orderList;
    }

    public List<OrderWithDishes> getCurrentOrdersQueue(String id) {
        List<Order> lst = getOrders(id);
        List<OrderWithDishes> list = new ArrayList<>();
        for (Order i : lst) {
            list.add(new OrderWithDishes(i.getId(), i.getUser(),
                    i.getDate(), i.getStatus(), i.getCook(),
                    cardService.getNamesOfDishes(i.getId())));
        }
        System.out.println(list);
        return list;
    }

    public List<OrderWithDishes> getPendingOrdersQueue(String id) {
        List<Order> lst = getOrdersForCook(id);
        List<OrderWithDishes> list = new ArrayList<>();
        for (Order i : lst) {
            list.add(new OrderWithDishes(i.getId(), i.getUser(),
                    i.getDate(), i.getStatus(), i.getCook(),
                    cardService.getNamesOfDishes(i.getId())));
        }
        System.out.println(list);
        return list;
    }

    public List<OrderWithDishes> getOrdersForDelivery(String id) {
        List<Order> lst = getOrdersForDeliver(id);
        List<OrderWithDishes> list = new ArrayList<>();
        for (Order i : lst) {
            list.add(new OrderWithDishes(i.getId(), i.getUser(),
                    i.getDate(), i.getStatus(), i.getCook(),
                    cardService.getNamesOfDishes(i.getId())));
        }
        System.out.println(list);
        return list;
    }
}
