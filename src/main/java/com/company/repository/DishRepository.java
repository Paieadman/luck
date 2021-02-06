package com.company.repository;

import com.company.entity.Dish;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DishRepository extends CrudRepository<Dish, Integer> {
    @Query("SELECT d from Dish d where d.category=?1")
    Iterable<Dish> findByCategory(String category);
}
