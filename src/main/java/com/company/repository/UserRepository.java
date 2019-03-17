package com.company.repository;

import com.company.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Integer> {
   @Query("SELECT u from User u where u.name=?1 and u.password=?2")
   User findByNameAndPassword(String name, String password);
//    User findByPassword();
   @Query("select u from User u where u.name=?1")
   User findUserByName(String name);
}