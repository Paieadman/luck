package com.company.entity;


import javax.persistence.*;


@Entity
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int orderId;
    private int dish;

    public Card() { }

    public Card(int orderId, int dish) {
        this.orderId = orderId;
        this.dish = dish;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getDish() {
        return dish;
    }

    public void setDish(int dish) {
        this.dish = dish;
    }
}
