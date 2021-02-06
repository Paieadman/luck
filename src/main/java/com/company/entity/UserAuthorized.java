package com.company.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class UserAuthorized {
    private String login;
    private String password;
    private String name;
    private String role;
    private int active;

    public UserAuthorized(String login, String password, String name, String role, int active) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.role = role;
        this.active = active;
    }

    public UserAuthorized(User user) {
        this.login = user.getLogin();
        this.password = user.getPassword();
        this.name = user.getName();
        this.role = user.getRole();
        this.active = user.getActive();
    }

    public UserAuthorized() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
