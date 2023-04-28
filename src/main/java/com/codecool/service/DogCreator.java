package com.codecool.service;

import com.codecool.model.Breed;
import com.codecool.model.Dog;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class DogCreator {

    private final Random random;

    public DogCreator() {
        this.random = new Random();
    }

    public Dog createRandomDog() {
        int age = random.nextInt(1, 20);
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 7;
        String name = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        Breed breed = Breed.values()[random.nextInt(Breed.values().length)];
        return new Dog(age, name, breed);
    }
}
