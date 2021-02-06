package com.company.controller;

import com.company.entity.*;
import com.company.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/orders/{id}/cook")
    public List<Order> getOrdersForCook(@PathVariable String id) {
        return orderService.getOrdersForCook(id);
    }

    @GetMapping("/orders/{id}/del")
    public List<Order> getOrdersForDeliver(@PathVariable String id) {
        return orderService.getOrdersForDeliver(id);
    }

    @GetMapping("/orders/{id}")
    public List<Order> getOrders(@PathVariable String id) {
        return orderService.getOrders(id);
    }

    @GetMapping("orders/{id}/performed")
    public List<Order> getPerformed(@PathVariable String id) {
        return orderService.getPerformed(id);
    }

    @GetMapping("orders/{id}/all")
    public List<Order> getOrdersForId(@PathVariable String id) {
        return orderService.getOrdersForId(id);
    }

    @RequestMapping("/orders/add/{id}")
    public Integer add(@PathVariable("id") String id) {
        return orderService.addOrder(Integer.parseInt(id));
    }

    @PostMapping("/{id}/order/status/update")
    public Integer updateStatus(@PathVariable("id") int id, @RequestBody String cook) {
        return orderService.updateStatus(id, Integer.parseInt(cook));
    }

    @GetMapping("{id}/confirm")
    public void confirm(@PathVariable("id") String id) {
        orderService.confirm(Integer.parseInt(id));
    }

    @RequestMapping("get/order/{id}")
    public Integer getCurrentOrder(@PathVariable("id") String id) {
        return orderService.getCurrentOrder(Integer.parseInt(id));
    }

    @RequestMapping("get/cards/{id}")
    public List<Dish> getDishesFromOrder(@PathVariable("id") String id) {
        return orderService.getDishesFromOrder(Integer.parseInt(id));
    }

    @PostMapping("get/Number/orders")
    public List<Long> getNumberOfOrders(@RequestBody String id) {
        return orderService.getNumberOfOrders(Integer.parseInt(id));
    }

    @PostMapping("delivery/order")
    public int deliveryOrder(@RequestBody DeliveryObject deliveryObject) {
        return orderService.takeDelivery(deliveryObject);
    }

    @PostMapping("/orders")
    public List<Integer> getHistory(@RequestBody String mail) {
        return orderService.getHistory(mail);
    }

    @RequestMapping("orders/current/queue/{id}")
    public List<OrderWithDishes> getCurrentOrdersQueue(@PathVariable("id") String id) {
        return orderService.getCurrentOrdersQueue(id);
    }

    @RequestMapping("orders/pending/queue/{id}")
    public List<OrderWithDishes> getPendingOrdersQueue(@PathVariable("id") String id) {
        return orderService.getPendingOrdersQueue(id);
    }

    @RequestMapping("orders/delivery/queue/{id}")
    public List<OrderWithDishes> getOrdersForDeliveryQueue(@PathVariable("id") String id) {
        return orderService.getOrdersForDelivery(id);
    }

}
