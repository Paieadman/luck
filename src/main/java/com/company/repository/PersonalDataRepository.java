package com.company.repository;

import com.company.entity.PersonalData;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface PersonalDataRepository extends CrudRepository<PersonalData, Integer> {

    @Query("select u from PersonalData u where u.user=?1")
    Optional<PersonalData> findByUser(int id);

    @Transactional
    @Modifying
    @Query("update PersonalData pd set pd.age=?5, pd.avatar=?7, pd.firstname=?3, pd.surname=?4, pd.mobileNumber=?6, pd.sex=?8 where pd.user=?2")
    void updatePersonalData(int id, int user, String firstname, String surname, int age, String mobileNumber, String avatar, String sex);
}
