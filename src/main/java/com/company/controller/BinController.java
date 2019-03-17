package com.company.controller;

import com.company.entity.Bin;
import com.company.entity.Dish;
import com.company.service.BinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class BinController {

    @Autowired
    private BinService binService;

    @PostMapping("/bin/add")
    public Bin addDish(int order, int dish) {
        return binService.addInBin(order, dish);
    }

    @PostMapping("/bin/get/all")
    public List<Dish> getDishInBin(int order) {
        return binService.getDishInBin(order);
    }

    @PostMapping("/bin/delete")
    public void deleteDishFromBin(int order, int dish) {
        binService.deleteDishFromBin(order, dish);
    }
}
