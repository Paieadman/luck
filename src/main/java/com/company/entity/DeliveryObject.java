package com.company.entity;

import javax.persistence.*;

public class DeliveryObject {
    private String street;
    private String house;
    private String flat;
    private Dish[] delivery;

    public DeliveryObject() {
    }

    public DeliveryObject(String street, String house, String flat, Dish[] delivery) {
        this.street = street;
        this.house = house;
        this.flat = flat;
        this.delivery = delivery;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public Dish[] getDelivery() {
        return delivery;
    }

    public void setDelivery(Dish[] delivery) {
        this.delivery = delivery;
    }
}
