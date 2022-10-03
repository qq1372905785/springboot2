package com.tdcare.boot.bean;

public class Dog {
    private String name;

    public Dog() {
    }

    public Dog(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString(){
        return "Dog_name"+name;
    }
}
