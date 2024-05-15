package com.fernando.entity;

public class Employee {

    public Employee(String name, Integer id) {
        this.name = name;
        this.identity = id;
    }

    private String name;

    private Integer identity;

    public String getName() {
        return name;
    }

    public Integer getIdentity() {
        return identity;
    }


}
