package com.company.service;

import com.company.entity.Card;
import com.company.entity.Dish;
import com.company.repository.CardRepository;
import com.company.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CardService {
    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private CardRepository cardRepository;

    public void addInBin(int order, Integer dish) {
        cardRepository.save(new Card(order, dish));
    }

    public List<Dish> getDishInBin(int order) {
        List<Card> it = cardRepository.findAllByOrder(order);
        List<Dish> dishes = new ArrayList<Dish>();
        it.forEach((n)-> {
            dishes.add(dishRepository.findById(n.getDish()).get());
        });
        return dishes;
    }

    public void deleteDishFromBin(int order, int dish) {
        cardRepository.delete(new Card(order, dish));
    }

    public List<String> getNamesOfDishes(int bin) {
        List<Card> dishes = cardRepository.findAllByOrder(bin);
        List<String> names = new ArrayList<String>();
        dishes.forEach((n)->{
            names.add(dishRepository.findById(n.getDish()).get().getName());
        });
        return names;
    }


}
