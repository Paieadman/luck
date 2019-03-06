package com.company.service;


import com.company.entity.Dish;
import com.company.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class MenuService {

    @Autowired
    private DishRepository dishRepository;

    public List<Dish> getMenu(){
        Iterable<Dish> dishes = dishRepository.findAll();
        List<Dish> ord = new ArrayList<Dish>();
        dishes.forEach(
                (n)->ord.add(n)
        );
        return ord;
    }

    public Dish addDish(Dish dish) {
        return dishRepository.save(dish);
    }
}
