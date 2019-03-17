package com.company.repository;

import com.company.entity.Bin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BinRepository extends CrudRepository<Bin, Integer> {

    @Query("select u from Bin u where u.order=?1")
    Iterable<Bin> findAllByOrder(int order);
}
