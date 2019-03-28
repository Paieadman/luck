package com.company.repository;

import com.company.entity.Order;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

public interface OrderRepository extends CrudRepository<Order, Integer> {

    @Query("select u from Order u where u.date=?1")
    Optional<Order> findByDate(String date);

    @Transactional
    @Modifying
    @Query("update Order u set u.status=u.status+1 where u.id =?1" )
    Integer updateStatusById(Integer id);

    @Query("select u from Order u where u.cook = ?1")
    Iterable<Order> findOrderByCook(int id);

    @Query("select u from Order u where u.status = 5")
    Iterable<Order> findAllPerformed();

    @Query("select u from Order u where u.status = 5 and u.user = ?1")
    Iterable<Order> findAllPerformedForUser(int id);

    @Query("select u from Order u where u.status = 5 and u.cook = ?1")
    Iterable<Order> findAllPerformedForCook(int id);

    @Query("select u from Order u where u.user = ?1")
    Iterable<Order> findAllForUser(int id);

    @Query("select u from Order u where u.cook = ?1")
    Iterable<Order> findAllForCook(int id);

    @Query("select u from Order u where u.status=2")
    Iterable<Order> findAllProcessingOrders();

    @Query("select u from Order u where u.status=2 and u.id = ?1")
    Iterable<Order> findAllProcessingOrdersById(int id);

    @Query("select u from Order u where u.status=2 and u.cook= ?1")
    Iterable<Order> findProcessingOrdersByCook(int id);

    @Query("select u from Order u where u.user=?1 and u.status=?2")
    Optional<Order> findOrderByIdAndStatus(int id, int i);

    @Query("select count(o) from Order o where (o.id=?1 or o.cook=?1) and o.status=1" )
    Optional<Long> countNumberOfCurrentOrders(Integer id);

    @Query("select count(o) from Order o where o.id=?1 or o.cook = ?1")
    Optional<Long> countNumberOfOrders(Integer id);

    @Query("select count(o) from Order o where (o.id=?1 or o.cook=?1) and o.status>1")
    Optional<Long> countNumberOfPerformedOrders(Integer id);

    @Transactional
    @Modifying
    @Query("update Order u set u.status=2 where u.id=?1")
    void updateOrderToConfirmed(int id);
}
