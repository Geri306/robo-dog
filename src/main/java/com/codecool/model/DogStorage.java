package com.codecool.model;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DogStorage {

    private final List<Dog> dogs;

    public DogStorage() {
        dogs = new ArrayList<>();
    }

    @Bean
    public List<Dog> getDogs() {
        return dogs;
    }
}
