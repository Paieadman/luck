package com.company.controller;
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

//    @RequestMapping("/orders")
//    public List<Order> getOrders(){
//        return orderService.getOrders();
//    }

    @GetMapping("/orders/{id}")
    public List<Order> getOrders(@PathVariable String id){
        return orderService.getOrders(id);
    }

//    @PostMapping("/orders/add")
//    public Order add(@RequestBody Order order){
//        return orderService.addOrder(order);
//    }
        @RequestMapping("/orders/add/{id}")
        public Integer add(@PathVariable("id") String id){
            return orderService.addOrder(Integer.parseInt(id));
        }

    @RequestMapping("/orders/{id}/remove")
    public String remove(@PathVariable int id){ return orderService.removeOrder(id);}

    @RequestMapping("/orders/{id}/update")
    public String edit(@PathVariable int id, String value, String pos){ return orderService.updateOrder(id,value,pos);}

    @RequestMapping("/order/{id}/status/update")
    public Integer updateStatus(@PathVariable int id) {
        System.out.println("i here");
        return orderService.updateStatus(id);
    }
}
