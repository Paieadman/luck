package com.company.repository;

import com.company.entity.Location;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LocationRepository extends CrudRepository<Location, Integer> {
    @Query("select u from Location u where u.orderId=?1")
    Optional<Location> findByOrder(int order);
}
