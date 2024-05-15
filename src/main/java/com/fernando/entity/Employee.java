package com.fernando.entity;

public class Employee {

    public Employee(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    private String name;

    private Integer id;

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }


}
