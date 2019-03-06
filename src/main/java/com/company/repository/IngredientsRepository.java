package com.company.repository;

import com.company.entity.Ingredients;
import org.springframework.data.repository.CrudRepository;

public interface IngredientsRepository extends CrudRepository<Ingredients, Integer> {
}
