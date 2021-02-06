package com.company.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PersonalData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int user;
    private String firstname;
    private String surname;
    private int age;
    private String sex;
    private String mobileNumber;
    private String avatar;

    public PersonalData() {
    }

    public PersonalData(int user, String firstname, String surname, int age, String sex, String mobileNumber, String avatar) {
        this.user = user;
        this.firstname = firstname;
        this.surname = surname;
        this.age = age;
        this.sex = sex;
        this.mobileNumber = mobileNumber;
        this.avatar = avatar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
