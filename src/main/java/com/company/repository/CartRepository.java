package com.company.repository;

import com.company.entity.Cart;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CartRepository extends CrudRepository<Cart, Integer> {

    @Query("select u from Cart u where u.orderId=?1")
    List<Cart> findAllByOrder(int order);

    @Transactional
    @Modifying
    @Query("delete from Cart c where c.dish=?2 and c.orderId=?1")
    void deleteByOrderAndDish(int order, int id);
}
