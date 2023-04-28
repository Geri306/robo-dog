package com.codecool.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Dog {

    @Id
    @GeneratedValue
    private long id;
    private int age;
    private String name;
    private Breed breed;

    public Dog(int age, String name, Breed breed) {
        this.age = age;
        this.name = name;
        this.breed = breed;
    }

    public Dog() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", breed=" + breed +
                '}';
    }
}
