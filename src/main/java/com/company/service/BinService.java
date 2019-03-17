package com.company.service;

import com.company.entity.Bin;
import com.company.entity.Dish;
import com.company.repository.BinRepository;
import com.company.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BinService {
    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private BinRepository binRepository;

    public Bin addInBin(int order, int dish) {
        return binRepository.save(new Bin(order, dish));
    }

    public List<Dish> getDishInBin(int order) {
        Iterable<Bin> it = binRepository.findAllByOrder(order);
        List<Dish> dishes = new ArrayList<Dish>();
        it.forEach((n)-> {
            dishes.add(dishRepository.findById(n.getDish()).get());
        });
        return dishes;
    }

    public void deleteDishFromBin(int order, int dish) {
        binRepository.delete(new Bin(order, dish));
    }
}
