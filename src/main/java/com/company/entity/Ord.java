package com.company.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int user;
    private String date;
    private int status;

    public Ord() {
    }

    public Ord(int user, String date, int status, String dishes) {
        this.user = user;
        this.date = date;
        this.status = status;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
