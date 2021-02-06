package com.company.repository;

import com.company.entity.History;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface HistoryRepository extends CrudRepository<History, Integer> {
    @Query("select h from History h where h.user=?1")
    Iterable<History> findAllByUser(int id);
}
