package com.company.repository;

import com.company.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends CrudRepository<User,Integer> {
   @Query("SELECT u from User u where u.login=?1 and u.password=?2")
   Optional<User> findByLoginAndPassword(String login, String password);
//    User findByPassword();
   @Query("select u from User u where u.name=?1")
   Optional<User> findUserByName(String name);

   //@Query(value = "update User u set u.active = true where u.id = ?1", nativeQuery = true)

   @Transactional
   @Modifying
   @Query("update User u set u.active = ?2 where u.id = ?1")
   int updateActive(int id, int session);

   @Query("select u from User u where u.id = ?1")
   Optional<User> getActiveById(int id);

   @Query("select u from User u where u.role='COOK' and u.active=1 and u.isBisy = 0 ")
   Iterable<User> findAllByRoleAndIsBisyAndActive();

   @Query("select u from User u where u.role='COOK' and u.active=1")
   Iterable<User> findAllByRoleAndActive();
}