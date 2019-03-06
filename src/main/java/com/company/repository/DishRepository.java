package com.company.repository;

import com.company.entity.Dish;
import org.springframework.data.repository.CrudRepository;


public interface DishRepository extends CrudRepository<Dish, Integer> {

}
