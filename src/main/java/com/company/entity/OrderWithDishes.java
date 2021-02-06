package com.company.entity;

import java.util.List;

public class OrderWithDishes {
    private int id;
    private int user;
    private String date;
    private int status;
    private int cook;
    private List<String> dishes;

    public OrderWithDishes(int id, int user, String date, int status, int cook, List<String> dishes) {
        this.id = id;
        this.user = user;
        this.date = date;
        this.status = status;
        this.cook = cook;
        this.dishes = dishes;
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

    public int getCook() {
        return cook;
    }

    public void setCook(int cook) {
        this.cook = cook;
    }

    public List<String> getDishes() {
        return dishes;
    }

    public void setDishes(List<String> dishes) {
        this.dishes = dishes;
    }
}
