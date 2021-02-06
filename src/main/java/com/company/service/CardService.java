package com.company.service;

import com.company.entity.Cart;
import com.company.entity.Dish;
import com.company.entity.Location;
import com.company.repository.CartRepository;
import com.company.repository.DishRepository;
import com.company.repository.LocationRepository;
import com.company.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.smartcardio.Card;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class CardService {
    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private LocationRepository locationRepository;

    public void addInBin(int order, Integer dish) {
        cartRepository.save(new Cart(order, dish));
    }

    public List<Dish> getDishInBin(int order) {
        List<Cart> it = cartRepository.findAllByOrder(order);
        List<Dish> dishes = new ArrayList<Dish>();
        it.forEach((n) -> {
            dishes.add(dishRepository.findById(n.getDish()).get());
        });
        return dishes;
    }

    public void deleteDishFromBin(int order, Dish dish) {
        cartRepository.deleteByOrderAndDish(order, dish.getId());
    }

    public List<String> getNamesOfDishes(int bin) {
        //Все id блюд для ордера
        List<Cart> orderToDishMapping = cartRepository.findAllByOrder(bin);
        List<String> names = new ArrayList<>();

        //Hack
        Iterable<Dish> dishes = dishRepository.findAll();

        dishes.forEach((dish -> {
            orderToDishMapping.forEach((dishObj) -> {
                if (dish.getId() == dishObj.getDish()) {
                    names.add(dish.getName());
                }
            });
        }));
        if (orderRepository.findById(bin).get().getUser() == 0) {
            Location location = locationRepository.findByOrder(bin).get();
            names.add(location.getStreet());
            names.add(location.getFlat());
            names.add(location.getHouse());
        }
        return names;
    }

}
