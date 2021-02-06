package com.company.controller;

import com.company.entity.Dish;
import com.company.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class CartController {

    @Autowired
    private CardService cardService;

    @PostMapping("/{order}/add")
    public void addDish(@PathVariable("order") String order, @RequestBody Integer dish) {
        cardService.addInBin(Integer.parseInt(order), dish);
    }

    @RequestMapping("/{order}/get/all")
    public List<Dish> getDishInBin(@PathVariable("order") int order) {
        return cardService.getDishInBin(order);
    }

    @PostMapping("/{order}/delete")
    public void deleteDishFromBin(@PathVariable("order") int order, Dish dish) {
        cardService.deleteDishFromBin(order, dish);
    }

    @RequestMapping("/get/{bin}")
    public List<String> getNamesOfDishes(@PathVariable int bin) {
        return cardService.getNamesOfDishes(bin);
    }
}
