package com.company.controller;

import com.company.entity.Dish;
import com.company.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping("/{order}/add")
    public void addDish(@PathVariable("order") String order, @RequestBody Integer dish) {
        System.out.println("it had come");
        cardService.addInBin(Integer.parseInt(order), dish);
    }

    @RequestMapping("/{order}/get/all")
    public List<Dish> getDishInBin(@PathVariable("order") int order) {
        return cardService.getDishInBin(order);
    }

    @PostMapping("/{bin}/delete")
    public void deleteDishFromBin(@PathVariable("order") int order, int dish) {
        cardService.deleteDishFromBin(order, dish);
    }

    @RequestMapping("/get/{bin}")
    public List<String> getNamesOfDishes(@PathVariable int bin) {
        return cardService.getNamesOfDishes(bin);
    }

    @RequestMapping("/confirm/{id}")
    public void confirm(@PathVariable("id") String id) {
        cardService.confirm(Integer.parseInt(id));
    }
}
