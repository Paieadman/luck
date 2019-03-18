package com.company.repository;

import com.company.entity.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OrderRepository extends CrudRepository<Order, Integer> {

    @Query("select u from Order u where u.date=?1")
    Optional<Order> findByDate(String date);
}
