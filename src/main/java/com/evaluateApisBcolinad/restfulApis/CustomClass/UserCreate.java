package com.evaluateApisBcolinad.restfulApis.CustomClass;

import java.util.List;

public class UserCreate {

    private String name;
    private String email;
    private String password;
    private List<Object> phones;

    public UserCreate(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Object> getPhones() {
        return phones;
    }

    public void setPhones(List<Object> phones) {
        this.phones = phones;
    }
}
