package com.company.repository;

import com.company.entity.Order;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface OrderRepository extends CrudRepository<Order, Integer> {

    @Query("select u from Order u where u.date=?1")
    Optional<Order> findByDate(String date);

    @Transactional
    @Modifying
    @Query("update Order u set u.status=u.status+1 where u.id =?1" )
    Integer updateStatusById(Integer id);
}
