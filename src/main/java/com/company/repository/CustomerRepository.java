package com.company.repository;

import com.company.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    @Query("SELECT c from Customer c where c.mail=?1 and c.password=?2")
    Optional<Customer> findByLoginAndPassword(String login, String password);

    @Query("select c from Customer c where c.mail=?1")
    Optional<Customer> findByMail(String mail);
}
