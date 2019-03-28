package com.company.controller;
import com.company.entity.Dish;
import com.company.entity.Order;
import com.company.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/orders/{id}")
    public List<Order> getOrders(@PathVariable String id){
        return orderService.getOrders(id);
    }

    @GetMapping("orders/{id}/performed")
    public List<Order> getPerformed(@PathVariable String id){
        return orderService.getPerformed(id);
    }

    @GetMapping("orders/{id}/all")
    public List<Order> getOrdersForId(@PathVariable String id){
        return orderService.getOrdersForId(id);
    }

    @RequestMapping("/orders/add/{id}")
    public Integer add(@PathVariable("id") String id){
            return orderService.addOrder(Integer.parseInt(id));
        }

    @PostMapping("/order/status/update")
    public Order updateStatus(@RequestBody int id) {
        return orderService.updateStatus(id);
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

}
