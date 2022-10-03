package com.tdcare.boot.bean;

public class User {
    private  String name;
    private  Integer age;

    private  Dog dog;



    public User() {
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {this.name = name;}
    public String getName() {
        return name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    public int getAge(Integer age) {
       return age;
    }
    public void setDog(Dog dog) {this.dog = dog;}
    public Dog getDog() {return dog;}

  }
