package com.company.repository;

import com.company.entity.Card;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CardRepository extends CrudRepository<Card,Integer> {

    @Query("select u from Card u where u.orderId=?1")
    List<Card> findAllByOrder(int order);


}
