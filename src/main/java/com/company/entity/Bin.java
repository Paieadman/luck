package com.company.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int order;
    private int dish;

    public Bin(int order, int dish) {
        this.order = order;
        this.dish = dish;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getDish() {
        return dish;
    }

    public void setDish(int dish) {
        this.dish = dish;
    }
}
