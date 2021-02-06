package com.company.entity;

import javax.persistence.*;

@Entity
@Table
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "order_id")
    private int order;
    @Column(name = "customer_id")
    private int user;

    public History(int order, int user) {
        this.order = order;
        this.user = user;
    }

    public History() {
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

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }
}
