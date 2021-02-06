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

    public List<Dish> getMenu() {
        Iterable<Dish> dishes = dishRepository.findAll();
        List<Dish> ord = new ArrayList<Dish>();
        dishes.forEach(
                (dish) -> ord.add(dish)
        );
        return ord;
    }

    public Dish addDish(Dish dish) {
        Dish newDish = new Dish(dish.getName(), dish.getCost(), dish.getComposition(), dish.getImage(), dish.getCategory());
        return dishRepository.save(newDish);
    }

    public List<Dish> getGroupOfDishes(String category) {
        System.out.println(category);
        if (!category.equals("all")) {
            Iterable<Dish> it = dishRepository.findByCategory(category);
            if (it.iterator().hasNext()) {
                List<Dish> lst = new ArrayList<>();
                it.forEach((Dish dish) -> {
                    lst.add(dish);
                });
                return lst;
            } else {
                return null;
            }
        } else {
            return getMenu();
        }
    }
}
