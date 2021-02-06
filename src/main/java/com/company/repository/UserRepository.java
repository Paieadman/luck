package com.company.repository;

import com.company.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    @Query("SELECT u from User u where u.login=?1 and u.password=?2")
    Optional<User> findByLoginAndPassword(String login, String password);

    @Query("select u from User u where u.name=?1")
    Optional<User> findUserByName(String name);

    @Transactional
    @Modifying
    @Query("update User u set u.active = ?2 where u.id = ?1")
    int updateActive(int id, int session);

    @Query("select u from User u where u.id = ?1")
    Optional<User> getActiveById(int id);

}