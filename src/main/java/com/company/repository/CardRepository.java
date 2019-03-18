package com.company.repository;

import com.company.entity.Card;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CardRepository extends CrudRepository<Card,Integer> {

    @Query("select u from Card u where u.orderId=?1")
    List<Card> findAllByOrder(int order);
}
