package com.company.controller;

import com.company.entity.Dish;
import com.company.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class MenuController {
    @Autowired
    private MenuService menuService;

    @RequestMapping("/menu")
    public List<Dish> getMenu() {
        return menuService.getMenu();
    }

    @RequestMapping("/menu/{category}")
    public List<Dish> getGroupOfDishes(@PathVariable("category") String category) {
        return menuService.getGroupOfDishes(category);
    }

    @PostMapping("/menu/add")
    public Dish addDish(Dish dish) {
        return menuService.addDish(dish);
    }
}
