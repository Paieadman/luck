package com.company.entity;

public class AuthorizationRequest {
    private String login;
    private  String password;

    public AuthorizationRequest() {
    }

    public AuthorizationRequest(String name, String password) {
        this.login = name;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String name) {
        this.login = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
